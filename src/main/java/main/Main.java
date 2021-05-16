package main;

import fxcontroller.TableApplication;
import model.Table;
import javafx.application.Application;

/**
 * The core of the program.
 */
public class Main {
    /**
     * The main method where the other methods in the {@link model.Table table} class will be called.
     * @param args this is basically the {@link model.Table table} we will use for the game.
     */
    public static void main(String[] args) {

        /*Table table = new Table();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(table.search(i,j)+ " ");
            }
            System.out.print("\n");
        }*/
        Application.launch(TableApplication.class, args);
    }
}
