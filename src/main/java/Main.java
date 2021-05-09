public class Main {

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
