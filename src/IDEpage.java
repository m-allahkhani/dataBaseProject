import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class IDEpage extends VBox {

    private  Button runBTN;
    private  Button startBTN;
    private  Button exitBTN;
    private  TextArea writeText;
    private  Button newTable;
    private javafx.scene.control.TableView table;
    private Label resultLable;
    private HBox writeBox;
    private HBox resultBox;
    private HBox buttonBox;
    private HBox result;

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

        newTable = new Button("New Table");
        newTable.setPrefWidth(150);
        newTable.setAlignment(Pos.CENTER);

        writeText = new TextArea();
        writeText.setPrefWidth(1000);
        writeText.setPrefHeight(500);
        writeText.setPromptText("write the path here...");

        table = new TableView();
        table.setPrefWidth(1000);
        table.setPrefHeight(100);
        //table.setDisable(true);
        resultLable = new Label();
        resultLable.setPrefWidth(1000);
        resultLable.setPrefHeight(30);
        result = new HBox(resultLable);
        result.setAlignment(Pos.CENTER);

        HBox writeBox = new HBox(writeText);
        writeBox.setAlignment(Pos.CENTER);

        HBox resultBox = new HBox(table);
        resultBox.setAlignment(Pos.CENTER);
        //resultBox.setDisable(true);

        HBox buttonBox = new HBox(startBTN, runBTN, exitBTN);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(8);

//this.getChildren().addAll(writeBox, buttonBox, resultBox);
        this.getChildren().addAll(writeBox, buttonBox, resultBox, result);
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

    public TableView getTable(){
        return table;
    }
///////////???????????
/*
public void setTable(TableView table){
       this.table = table;
       this.table.setPrefWidth(1000);
       this.table.setPrefHeight(100);
        //table.setDisable(true);

    }*/

    public void setNewTable(){

        this.getChildren().removeAll(writeBox, buttonBox, resultBox, result);
        table = new TableView();
        this.table.setPrefWidth(1000);
        this.table.setPrefHeight(100);
        //table.setDisable(true);
        resultBox = new HBox(table);
        resultBox.setAlignment(Pos.CENTER);
        this.getChildren().addAll(writeBox, buttonBox, resultBox, result);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    public Label getResultLable() {
        return resultLable;
    }
}
