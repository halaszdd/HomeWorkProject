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
}
