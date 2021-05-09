public class Main {
    /**
     * The main method where the other methods in the Table class will be called.
     * @param args this is basically the Table we will use for the game.
     */
    public static void main(String[] args) {

        Table table = new Table();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(table.table[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
