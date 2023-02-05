package DataBaseProject.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.awt.*;

public class DisplayTheListOfUsers  extends VBox {
    private javafx.scene.control.Label onlineUsers;
    public javafx.scene.control.Label inorderUsers;
    private TableView online;
    private TableView inprder;

    public DisplayTheListOfUsers(){
        this.inorderUsers = new javafx.scene.control.Label("inperson Users");
        this.onlineUsers = new Label("online Users");
        online = new TableView();
        online.setPrefHeight(400);
        online.setPrefWidth(1000);
        inprder = new TableView();
        inprder.setPrefWidth(1000);
        inprder.setPrefHeight(400);

        HBox hBox1 = new HBox(this.inorderUsers);
        HBox hBox2 = new HBox(this.onlineUsers);
        HBox hBox3 = new HBox(online);
        HBox hBox4 = new HBox(inprder);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        this.getChildren().addAll(hBox1, hBox4, hBox2, hBox3);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(QueryPage
                .class.getResourceAsStream("image2.png")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.setBackground(new Background(backgroundImage));


    }

    public TableView getOnline() {
        return online;
    }

    public TableView getInprder() {
        return inprder;
    }
}
