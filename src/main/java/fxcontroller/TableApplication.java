package fxcontroller;

        import java.io.IOException;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

/**
 * This class is responsible for creating the window where the game will happen.
 */
public class TableApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI.fxml"));
        stage.setTitle("2.1 Homework Board game");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        TableController.endScreen(stage);
        stage.show();
    }

}