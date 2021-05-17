package model;

/**
 *Represents the board.
 */
public class Table {
    /**
     * The representation of the {@code model.Table}.
     */
    private int[][] table;

    /**
     * This constructor creates a board where the game will happen.
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
     * This method checks the parameters got from the player if they are valid.
     * @param iindex a number which gives the serial number of the line where we will go
     * @param jindex a number which gives the serial number of the column where we will go
     * @return if this method returns a true value then the numbers given by the player not point out of the array
     */
    public boolean checkParameters(int iindex, int jindex)
    {
        if (iindex>=11 || jindex>=11 || iindex<=0 || jindex<=0)
        {
            return false;
        }
        return true;
    }

    /**
     * This is a getter which we can use to get the value of a private record.
     * @param iindex a number which gives the serial number of the line we are looking for
     * @param jindex a number which gives the serial number of the column we are looking for
     * @return gives back the value from the cell we found
     */
    public int search(int iindex, int jindex)
    {
        return this.table[iindex][jindex];
    }

    /**
     * This is a setter which we can use to give a value to a private record.
     * @param iindex a number which gives the serial number of the line where we will write
     * @param jindex a number which gives the serial number of the column where we will write
     * @param getchar the number given by a player for painting the given element on the board
     */
    public void edit(int iindex, int jindex, int getchar)
    {
        if(checkParameters(iindex, jindex))
        {
            if ((getchar!=1 || getchar!=2 ) && this.table[iindex][jindex] == 0)
            {
                this.table[iindex][jindex] = getchar;
            }
        }
    }

    /**
     * This is a getter which will return us the {@link Table table}.
     * @return the current state of the model.Table
     */
    private int[][] getTable() {
        return table;
    }

    /**
     * This setter will reset the table by overwriting the current one with a new one.
     */
    public void resetTable()
    {
        this.table = new Table().getTable();
    }
}