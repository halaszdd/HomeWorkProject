/**
 * The package the contains all the classes which are related to UI handling.
 */
package fxcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * This class is responsible for creating the end game window.
 */
public class EndScreenController {
    private static String winner = new String();

    static Stage stage = new Stage();

    @FXML
    private Label fxlabel;

    @FXML
    private Button fxbutton;

    @FXML
    private void initialize() {
        fxbutton.setOnMouseClicked(this::handleMouseClick);
        fxlabel.setText(winner +" wins");
    }

    @FXML
    private void handleMouseClick(MouseEvent event){
        stage.close();
    }

    /**
     * This method's job is to get the stage from the TableController class.
     * @param getstage the variable which trough we get the stage.
     */
    public static void endScreen(Stage getstage){
        stage=getstage;
    }

    /**
     * This method give us back who won the game.
     * @param winneris is a string which can give back Blue or Red
     */
    public static void theWinnerIs(String winneris){
        winner=winneris;
    }

}
