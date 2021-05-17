package fxcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


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
        //fxlabel.setDisable(false);
        fxlabel.setText(winner +" wins");
        //fxlabel.setDisable(true);
    }

    @FXML
    private void handleMouseClick(MouseEvent event){
        stage.close();
    }

    public static void endScreen(Stage getstage){
        stage=getstage;
    }
    public static void theWinnerIs(String winneris){
        winner=winneris;
    }

}
