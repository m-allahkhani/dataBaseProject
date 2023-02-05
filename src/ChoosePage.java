import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ChoosePage extends VBox {

    private Button submitBTN;
    private RadioButton fileBTN;
    private RadioButton writeBTN;
    private RadioButton showTheQuery;
    private TextField pathTF;
    private Label errorLBL;
    private Label chooseLBL;

    public ChoosePage(){

        chooseLBL = new Label("Choose:");
        chooseLBL.setFont(new Font(25));
        chooseLBL.setAlignment(Pos.CENTER);

        showTheQuery = new RadioButton(" The Wrote Queries  ");
        showTheQuery.setTextFill(Color.BLACK.darker());
        showTheQuery.setAlignment(Pos.CENTER);
        showTheQuery.setFont(new Font(15));

        writeBTN = new RadioButton(" Write a code   ");
        writeBTN.setTextFill(Color.BLACK.darker());
        writeBTN.setAlignment(Pos.CENTER);
        writeBTN.setFont(new Font(15));

        fileBTN = new RadioButton("Enter the path of file: ");
        fileBTN.setAlignment(Pos.CENTER);
        fileBTN.setFont(new Font(15));

        pathTF = new TextField();
        pathTF.setPrefHeight(40);
        pathTF.setPrefWidth(400);
        pathTF.setPromptText("write the path here...");
        pathTF.setAlignment(Pos.TOP_LEFT);

        errorLBL = new Label("");

        submitBTN = new Button("submit");
        submitBTN.setPrefHeight(30);
        submitBTN.setPrefWidth(100);
        submitBTN.setAlignment(Pos.CENTER);

        HBox pathBox = new HBox(pathTF);
        pathBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(chooseLBL,showTheQuery, writeBTN, fileBTN, pathBox, errorLBL, submitBTN);
        this.setSpacing(30);
        this.setAlignment(Pos.CENTER);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(ChoosePage.class.getResourceAsStream("image2.png")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.setBackground(new Background(backgroundImage));

    }

    public Label getChooseLBL() {
        return chooseLBL;
    }

    public Button getSubmitBTN() {
        return submitBTN;
    }

    public RadioButton getShowTheQuery(){
        return  showTheQuery;
    }

    public RadioButton getFileBTN() {
        return fileBTN;
    }

    public RadioButton getWriteBTN() {
        return writeBTN;
    }

    public TextField getPathTF() {
        return pathTF;
    }

    public Label getErrorLBL() {
        return errorLBL;
    }
}
