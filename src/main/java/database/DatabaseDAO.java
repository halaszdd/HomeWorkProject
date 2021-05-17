package database;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface DatabaseDAO {
    @SqlUpdate("CREATE TABLE database (player INTEGER PRIMARY KEY, matcheswon INTEGER)")
    void createDatabase();

    @SqlUpdate("UPDATE database SET matcheswon =:matcheswon WHERE player IN(:player)")
    void updateMatcheswon(@Bind("matcheswon") int matcheswon, @Bind("player") int player);

    @SqlUpdate("INSERT INTO database (player,matcheswon) VALUES (:player,1)")
    void insertPlayer(@Bind("player") int player);

    @SqlQuery("SELECT matcheswon FROM database WHERE player IN(:player)")
    int numberOfTotalmatcheswon(@Bind("player") int player);

    @SqlQuery("SELECT EXISTS (SELECT * FROM database WHERE player IN(:player))")
    boolean playerAlreadyExists(@Bind("player") int player);
}
