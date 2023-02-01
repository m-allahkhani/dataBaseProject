package DataBaseProject.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class QueryPage extends VBox {

    Button[] btns;
    Label describe;
    Label choose;
    TextArea result;
    Button backBtn;
    Button exitBtn;

    public  QueryPage() {
        btns = new Button[21];

        btns[0] = new Button("query1");
        btns[0].setPrefWidth(100);
        btns[1] = new Button("query2");
        btns[1].setPrefWidth(100);
        btns[2] = new Button("query3");
        btns[2].setPrefWidth(100);
        btns[3] = new Button("query4");
        btns[3].setPrefWidth(100);
        btns[4] = new Button("query5");
        btns[4].setPrefWidth(100);
        btns[5] = new Button("query6");
        btns[5].setPrefWidth(100);
        btns[6] = new Button("query7");
        btns[6].setPrefWidth(100);
        btns[7] = new Button("query8");
        btns[7].setPrefWidth(100);
        btns[8] = new Button("query9");
        btns[8].setPrefWidth(100);
        btns[9] = new Button("query10");
        btns[9].setPrefWidth(100);
        btns[10] = new Button("query11");
        btns[10].setPrefWidth(100);
        btns[11] = new Button("query12");
        btns[11].setPrefWidth(100);
        btns[12] = new Button("query13");
        btns[12].setPrefWidth(100);
        btns[13] = new Button("query14");
        btns[13].setPrefWidth(100);
        btns[14] = new Button("query15");
        btns[14].setPrefWidth(100);
        btns[15] = new Button("query16");
        btns[15].setPrefWidth(100);
        btns[16] = new Button("query17");
        btns[16].setPrefWidth(100);
        btns[17] = new Button("query18");
        btns[17].setPrefWidth(100);
        btns[18] = new Button("query19");
        btns[18].setPrefWidth(100);
        btns[19] = new Button("query20");
        btns[19].setPrefWidth(100);
        btns[20] = new Button("query21");
        btns[20].setPrefWidth(100);


        describe = new Label("");
        describe.setPrefHeight(100);
        describe.setPrefWidth(800);

        choose   = new Label("Choose a query: ");
        choose.setFont(new Font(25));
        choose.setAlignment(Pos.CENTER);

        exitBtn = new Button("Exit");
        exitBtn.setPrefWidth(200);

        backBtn = new Button("Back");
        backBtn.setPrefWidth(200);

        HBox chooseLBL = new HBox(choose);
        chooseLBL.setAlignment(Pos.CENTER);

        HBox desLBL = new HBox(describe);
        desLBL.setAlignment(Pos.CENTER);

        HBox queryBox1 = new HBox(btns[0], btns[1], btns[2], btns[3], btns[4], btns[5], btns[6]);
        queryBox1.setAlignment(Pos.CENTER);
        queryBox1.setSpacing(10);

        HBox queryBox2 = new HBox(btns[7], btns[8], btns[9], btns[10], btns[11], btns[12], btns[13]);
        queryBox2.setAlignment(Pos.CENTER);
        queryBox2.setSpacing(10);

        HBox queryBox3 = new HBox(btns[14], btns[15], btns[16], btns[17], btns[18], btns[19], btns[20]);
        queryBox3.setAlignment(Pos.CENTER);
        queryBox3.setSpacing(10);

        result = new TextArea();
        result.setPrefWidth(700);
        result.setPrefHeight(350);

        HBox resultBox = new HBox(result);
        resultBox.setAlignment(Pos.CENTER);

        HBox btnBox = new HBox(backBtn, exitBtn);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setSpacing(10);


        VBox queryBox = new VBox();
        queryBox.getChildren().addAll(queryBox1, queryBox2, queryBox3);
        queryBox.setSpacing(10);

        HBox HVBox = new HBox(queryBox);
        HVBox.setAlignment(Pos.CENTER);


        this.getChildren().addAll(chooseLBL, HVBox, desLBL, resultBox, btnBox);
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(QueryPage
                .class.getResourceAsStream("image2.png")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.setBackground(new Background(backgroundImage));
    }

    public Button getBtn (int i) {
        return btns[i];
    }

    public Label getDescribe(){
        return describe;
    }

    public TextArea getResult(){
        return result;
    }

    public Button getExitBtn(){
        return  exitBtn;
    }

    public Button getBackBtn(){
        return backBtn;
    }

}
