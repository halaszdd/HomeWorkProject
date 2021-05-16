package fxcontroller;

        import javafx.beans.binding.ObjectBinding;
        import javafx.fxml.FXML;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.StackPane;
        import javafx.scene.paint.Color;
        import javafx.scene.paint.Paint;
        import javafx.scene.shape.Circle;
        import javafx.scene.shape.Rectangle;
        import model.Table;
        import org.w3c.dom.css.Rect;

        import javax.swing.text.Position;
        import java.util.logging.Logger;

public class TableController {

    static int numberofclicks=0;

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
        //var piece = new Rectangle(66,66);
        rectangle.setOnMouseClicked(this::handleMouseClick);
        rectangle = checkColor(i,j,rectangle);
        return rectangle;
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
        //Logger.debug("Click on rectangle {}", position);
        if(rectangleState(rectangle)) {
            rectangle.getChildren().add(createPiece(playerTurn(isOdd(numberofclicks))));
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
    private static boolean rectangleState(StackPane rectangle){
        Rectangle rectangle1 = (Rectangle) rectangle.getChildren().get(0);
        if (!rectangle1.getFill().equals(Color.TRANSPARENT)) {
            return false;
        }
        return true;
    }
}