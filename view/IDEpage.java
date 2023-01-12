package DataBaseProject.view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class IDEpage extends VBox {

    private  Button runBTN;
    private  Button startBTN;
    private  Button exitBTN;
    private  TextArea writeText;
    private  TextArea result;


    public IDEpage(){

        runBTN = new Button("Run");
        runBTN.setPrefWidth(150);
        runBTN.setAlignment(Pos.CENTER);

        startBTN = new Button("Start again!");
        startBTN.setPrefWidth(150);
        startBTN.setAlignment(Pos.CENTER);

        exitBTN = new Button("Exit");
        exitBTN.setPrefWidth(150);
        exitBTN.setAlignment(Pos.CENTER);

        writeText = new TextArea();
        writeText.setPrefWidth(1000);
        writeText.setPrefHeight(500);
        writeText.setPromptText("write the path here...");

        result = new TextArea();
        getResult().setPrefWidth(1000);
        getResult().setPrefHeight(100);


        HBox writeBox = new HBox(writeText);
        writeBox.setAlignment(Pos.CENTER);

        HBox resultBox = new HBox(getResult());
        resultBox.setAlignment(Pos.CENTER);
        resultBox.setDisable(true);

        HBox buttonBox = new HBox(startBTN, runBTN, exitBTN);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(8);

        this.getChildren().addAll(writeBox, buttonBox, resultBox);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        BackgroundImage backgroundImage = new BackgroundImage(new Image(IDEpage.class.getResourceAsStream("image2.png")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.setBackground(new Background(backgroundImage));

    }

    public Button getRunBTN() {
        return runBTN;
    }

    public Button getExitBTN() {
        return exitBTN;
    }

    public Button getStartBTN() {
        return startBTN;
    }

    public TextArea getWriteTF() {
        return writeText;
    }

    public TextArea getResult() {
        return result;
    }
}
