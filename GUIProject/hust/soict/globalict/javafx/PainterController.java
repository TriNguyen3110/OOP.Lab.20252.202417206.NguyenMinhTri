package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadio;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getX() >= 0 && event.getY() >= 0) {
            // if pen is being used, then color is set to be black
            Color inkColor = penRadio.isSelected() ? Color.BLACK : Color.WHITE;

            // draw a small circle at the point located by mouse
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}