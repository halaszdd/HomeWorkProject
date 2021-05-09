import java.lang.reflect.Array;

/**
 *Represents the board
 */
public class Table {

    public int[][] table;

    /**
     * This method creates a board where the game will happen.
     */
    public Table()
    {
        int[][]array = new int[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(i%2==0 && j%2!=0){
                    array[i][j]=1;
                }
                if(i%2!=0 && j%2==0){
                    array[i][j]=2;
                }
            }
        }
        this.table = array;
    }

    /**
     * This method checks the parameters got from the player if they are valid
     * @param iindex a number which gives the serial number of the line where we will go
     * @param jindex a number which gives the serial number of the column where we will go
     * @return if this method returns a true value then the numbers given by the player not point out of the array
     */
    public boolean CheckParameters(int iindex, int jindex)
    {
        if (iindex>=11 || jindex>=11 || iindex<=0 || jindex<=0)
        {
            return false;
        }
        return true;
    }

    /**
     * This method is used for searching a given element in the array
     * @param iindex a number which gives the serial number of the line we are looking for
     * @param jindex a number which gives the serial number of the column we are looking for
     * @return gives back the value from the cell we found
     */
    public int Search(int iindex, int jindex)
    {
        return this.table[iindex][jindex];
    }

    /**
     * This method is used for editing a value on the board
     * @param iindex a number which gives the serial number of the line where we will write
     * @param jindex a number which gives the serial number of the column where we will write
     * @param getchar the number given by a player for painting the given element on the board
     * @throws Exception if the number is not correct (1 or 2), or the chosen field is already taken by another player.
     */
    public void Edit(int iindex, int jindex, int getchar ) throws Exception
    {
        int[][] tempTable = this.table;
        if(CheckParameters(iindex, jindex))
        {
            if ((getchar!=1 && getchar!=2 ) && tempTable[iindex][jindex] == 0)
            {
                tempTable[iindex][jindex] = getchar;
            }
            else
                {
                throw new Exception("This field is already taken!");
            }
        }
    }
}
