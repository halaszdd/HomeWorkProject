package fxcontroller;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.StackPane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;
        import model.Table;
        import org.tinylog.Logger;

/**
 * This class is responsible for handling the fx interface.
 */
public class TableController {

    static int numberofclicks=0;

    Table table = new Table();

    static Stage stage = new Stage();

    @FXML
    private GridPane tablefx;

    @FXML
    private void initialize() {
        for (int i = 0; i < tablefx.getRowCount(); i++) {
            for (int j = 0; j < tablefx.getColumnCount(); j++) {
                var rectangle  = createRectangle(i, j);
                tablefx.add(rectangle, j, i);
            }
        }
    }

    private StackPane createRectangle(int i, int j) {
        var rectangle = new StackPane();
        rectangle.getStyleClass().add("rectangle");
        rectangle.setOnMouseClicked(this::handleMouseClick);
        rectangle = checkColor(i,j,rectangle);
        return rectangle;
    }

    private static Rectangle changePiece(Color color,StackPane rectangle) {
        Rectangle rectangle1 = (Rectangle) rectangle.getChildren().get(0);
        rectangle1.setFill(color);
        return rectangle1;
    }
    private static Rectangle createPiece(Color color) {
        var piece = new Rectangle(66,66);
        piece.setFill(color);
        return piece;
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        var rectangle = (StackPane) event.getSource();
        numberofclicks++;
        var row = GridPane.getRowIndex(rectangle);
        var col = GridPane.getColumnIndex(rectangle);
        Logger.info("Click on rectangle {}", row,col);
        if(rectangleState(row,col)) {
                table.edit(row,col,(charType(numberofclicks)));
                rectangle.getChildren().set(0,changePiece((playerTurn(isOdd(numberofclicks))),rectangle));
                rectangle.setDisable(true);
                if(blueWins())
                {
                    /*try {
                        DatabaseController.updateDatabase(1);
                    }catch (Exception e){
                        throw new RuntimeException(e.getMessage());
                    }*/
                    try{
                        EndScreenController.theWinnerIs("Blue");
                        Logger.info("Blue Wins!");
                        Parent root = FXMLLoader.load(getClass().getResource("/endScreen.fxml"));
                        stage.setTitle("Result");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        EndScreenController.endScreen(stage);
                        stage.show();
                    }catch (Exception e){
                        Logger.error(e);
                        throw new RuntimeException("File not found!");
                    }

                }
                if(redWins())
                {
                    /*try {
                        DatabaseController.updateDatabase(2);
                    }catch (Exception e){
                        throw new RuntimeException(e.getMessage());
                    }*/
                    try{
                        EndScreenController.theWinnerIs("Red");
                        Logger.info("Red Wins!");
                        Parent root = FXMLLoader.load(getClass().getResource("/endScreen.fxml"));
                        stage.setTitle("Result");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        EndScreenController.endScreen(stage);
                        stage.show();
                    }catch (Exception e){
                        Logger.error(e);
                        throw new RuntimeException("File not found!");
                    }
                }

        }


    }

    private static StackPane checkColor(int row, int col, StackPane rectangle){
        Table table = new Table();
        switch (table.search(row,col)){
            case 0 -> rectangle.getChildren().add(createPiece(Color.TRANSPARENT));
            case 1 -> rectangle.getChildren().add(createPiece(Color.BLUE));
            case 2 -> rectangle.getChildren().add(createPiece(Color.RED));
        }
        return rectangle;
    }
    private static boolean isOdd(int numberofclicks) {
        if (numberofclicks%2==1){
            return true;
        }
        return false;
    }
    private static Color playerTurn(boolean isBluenext){
        if (isBluenext){
            return Color.BLUE;
        }
        else
        {
            return Color.RED;
        }
    }
    private boolean rectangleState(int row, int col){
        switch (table.search(row,col)) {
            case 0 -> {return true;}
            default -> {return false;}
        }
    }
    private int charType(int numberofclicks){
        if(numberofclicks%2==1){
            return 1;
        }
        else{
            return 2;
        }
    }

    private boolean redWins(){
        int redrectangles=0;
        for (int i=0;i<11;i++)
        {
            if(redrectangles==11)
            {
                return true;
            }
            redrectangles=0;
            for (int j=0;j<11;j++)
            {
                if(table.search(i,j)==2)
                {
                    redrectangles++;
                }
            }
        }
        return false;
    }
    private boolean blueWins(){
        int bluerectangle=0;
        for (int i=0;i<11;i++)
        {
            if(bluerectangle==11)
            {
                return true;
            }
            bluerectangle=0;
            for (int j=0;j<11;j++)
            {
                if(table.search(j,i)==1)
                {
                    bluerectangle++;
                }
            }
        }
        return false;
    }

    /**
     * This method's job is to get the stage from the TableApplication class.
     * @param getstage the variable which trough we get the stage from the OS
     */
    public static void endScreen(Stage getstage){
        stage=getstage;
    }
}