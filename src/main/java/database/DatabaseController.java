package database;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.h2.H2DatabasePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DatabaseController {

        private static Jdbi jdbi;

        private DatabaseController()
        {
            this.jdbi=Jdbi.create("jdbc:h2:file:~/.database/numberofwins","sa","");
            this.jdbi.installPlugin(new SqlObjectPlugin());
            this.jdbi.installPlugin(new H2DatabasePlugin());
            try
            {
                jdbi.withExtension(DatabaseDAO.class, dao -> {dao.createDatabase(); return true;});
            }
            catch (Exception e)
            {
                //Logger.info("DB already exists");
            }
        }

        public static Jdbi getInstance()
        {
            if(jdbi==null)
            {
                new DatabaseController();
            }
            return jdbi;
        }
        public static void updateDatabase(int winnerName)
        {
            new DatabaseController();
            boolean playerAlreadyExists = jdbi.withExtension(DatabaseDAO.class, dao -> {dao.playerAlreadyExists(winnerName);return true;});

            if(playerAlreadyExists)
            {
                int wins = jdbi.withExtension(DatabaseDAO.class, dao -> dao.numberOfTotalmatcheswon(winnerName));
                jdbi.withExtension(DatabaseDAO.class, dao ->
                {
                    dao.updateMatcheswon(wins+1,winnerName);
                    return true;
                });
            }
            else
            {
                jdbi.withExtension(DatabaseDAO.class, dao -> {dao.insertPlayer(winnerName);return true;});
            }
        }
}
