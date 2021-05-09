import java.lang.reflect.Array;

public class Table {

    public int[][] table;

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
    public boolean CheckParameters(int iindex, int jindex)
    {
        if (iindex>=11 || jindex>=11 || iindex<=0 || jindex<=0)
        {
            return false;
        }
        return true;
    }
    public int Search(int iindex, int jindex)
    {
        return this.table[iindex][jindex];
    }

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
