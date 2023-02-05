

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class QueryPage extends VBox {

    Button[] btns;
    Label describe;
    Label choose;
    TextArea result;
    Button backBtn;
    Button exitBtn;
    TextField textField1;
    TextField textField2;
    Label label1;
    Label label2;

    @FXML
    TableView tableview_orderTL;


    public static ObservableList<Product> list = FXCollections.observableArrayList();




    static ObservableList<gold> listgold = FXCollections.observableArrayList();
    static ObservableList<jewellery> listjewerly = FXCollections.observableArrayList();
    static ObservableList<Coins> listcoin = FXCollections.observableArrayList();
    ConnectData connectData = new ConnectData();

    public  QueryPage() {
        btns = new Button[18];

        btns[0] = new Button("query1");
        btns[0].setPrefWidth(100);
        /////////
        btns[0].setOnAction(event -> {
            String[] columnsCoin={"type_name","C_year","weight","price","discount"};
            String[] columnsGold={"type_name","idProduct","weight","country","price","discount"};
            String[] columnsJewerly={"type_name","idProduct","weight","country","price","discount"};
            StackPane root=new StackPane();
            Stage getLTorder= new Stage();
            getLTorder.setTitle("products list");
            Scene scene=new Scene(root, 724, 714);
            getLTorder.setScene(scene);
            TableView goldTableView=new TableView();
            goldTableView.setMaxHeight(203.0);
            goldTableView.setMaxWidth(524.0);
            goldTableView.setLayoutX(100.0);
            goldTableView.setLayoutY(47.0);
            TableView jewerlyTableView=new TableView();
            jewerlyTableView.setMaxHeight(203.0);
            jewerlyTableView.setMaxWidth(524.0);
            jewerlyTableView.setLayoutX(100.0);
            jewerlyTableView.setLayoutY(261.0);
            TableView coinTableView=new TableView();
            coinTableView.setMaxHeight(203.0);
            coinTableView.setMaxWidth(524.0);
            coinTableView.setLayoutX(100.0);
            coinTableView.setLayoutY(502.0);
            Text text1=new Text("Gold");
            text1.setStyle("-fx-fill: Gold;");
            text1.setLayoutX(308.0);
            text1.setLayoutY(39.0);
            Text text2=new Text("Jewerly");
            text2.setStyle("-fx-fill: Gold;");
            text2.setLayoutX(308.0);
            text2.setLayoutY(253.0);
            Text text3=new Text("Coin");
            text3.setStyle("-fx-fill: Gold;");
            text3.setLayoutX(308.0);
            text3.setLayoutY(490.0);
            text1.setWrappingWidth(136.43634033203125);
            text2.setWrappingWidth(136.43634033203125);
            text3.setWrappingWidth(136.43634033203125);
            VBox vBox=new VBox(text1,goldTableView,text2,jewerlyTableView,text3,coinTableView);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(15);
            root.getChildren().addAll(vBox);
            List <List> lists=connectData.getDataproducts();
      //      root.setStyle("-fx-background-image: url('file:E:/PROJECTS/dbGUI/dbGUI/src/images3.gif');");
            connectData.SetDataOnTableProducts(goldTableView,jewerlyTableView,
                    coinTableView,lists.get(0),lists.get(1),lists.get(2));
            getLTorder.show();
        });
        ////////
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
        ///////
         btns[6].setOnAction(event -> {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            String start=textField1.getText();
            String end=textField2.getText();
            if(checkDate(start) && checkDate(end)){
                StackPane root=new StackPane();
                Stage stage= new Stage();
                stage.setTitle("best sellers");
                Scene scene=new Scene(root, 701, 567);
                stage.setScene(scene);
                TableView tableView=new TableView();
                root.getChildren().add(tableView);
                tableView.setMaxHeight(401.0);
                tableView.setMaxWidth(575.0);
                tableView.setLayoutX(65);
                tableView.setLayoutY(69);
       //         root.setStyle("-fx-background-image: url('file:image3.gif');");
                String[] columns={"type_name","idProduct","count","price","idOrders"};
                connectData.SetDataOnTableLTorder(tableView,connectData.getDatabestseller(start,end),columns);
                stage.show();
            }
            else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setHeaderText("invalid input for bestseller query.");
                alert.setContentText("You have to type date with this format yyyy-mm-dd the first input is start date and the second one is end date");
                alert.showAndWait();
                textField1.clear();
                textField2.clear();
            }
        });
        ///////
        btns[7] = new Button("query8");
        btns[7].setPrefWidth(100);
        btns[8] = new Button("query9");
        btns[8].setPrefWidth(100);
        btns[9] = new Button("query10");
        btns[9].setPrefWidth(100);
        btns[10] = new Button("query11");
        btns[10].setPrefWidth(100);
        ///////
       // btns[0] = new Button("last ten order");

        btns[10].setOnAction(event -> {
        StackPane root=new StackPane();
        Stage getLTorder= new Stage();
        getLTorder.setTitle("last ten order");
        Scene scene=new Scene(root, 701, 567);
        getLTorder.setScene(scene);
        TableView tableView=new TableView();
        root.getChildren().add(tableView);
        tableView.setMaxHeight(401.0);
        tableView.setMaxWidth(575.0);
        tableView.setLayoutX(65);
        tableView.setLayoutY(69);
    //    root.setStyle("-fx-background-image: url('file:E:/PROJECTS/dbGUI/dbGUI/src/images3.gif');");
        String[] columns={"type_name","idProduct","price","idOrders","f_date"};
        connectData.SetDataOnTableLTorder(tableView,connectData.getDataLastTenOrder(login.getCustomerID()),columns);
        getLTorder.show();
        });
        //////
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

        HBox queryBox1 = new HBox(btns[0], btns[1], btns[2], btns[3], btns[4], btns[5]);
        queryBox1.setAlignment(Pos.CENTER);
        queryBox1.setSpacing(10);

        HBox queryBox2 = new HBox(btns[6], btns[7], btns[8], btns[9], btns[10], btns[11]);
        queryBox2.setAlignment(Pos.CENTER);
        queryBox2.setSpacing(10);

        HBox queryBox3 = new HBox(btns[12], btns[13], btns[14], btns[15], btns[16], btns[17]);
        queryBox3.setAlignment(Pos.CENTER);
        queryBox3.setSpacing(10);

        textField1=new TextField();
        label1=new Label("input 1");
        label2=new Label("input 2");
        textField2=new TextField();
        textField1.setPrefWidth(100);
        textField1.setPrefHeight(30);
        textField2.setPrefWidth(100);
        textField2.setPrefHeight(30);

        HBox hBox=new HBox(label1,textField1,label2,textField2);
        hBox.setSpacing(20.0);
        HBox inputBox = new HBox(hBox);
        inputBox.setAlignment(Pos.CENTER);

        result = new TextArea();
        result.setPrefWidth(700);
        result.setPrefHeight(350);

        HBox btnBox = new HBox(backBtn, exitBtn);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setSpacing(10);


        VBox queryBox = new VBox();
        queryBox.getChildren().addAll(queryBox1, queryBox2, queryBox3);
        queryBox.setSpacing(10);

        HBox HVBox = new HBox(queryBox);
        HVBox.setAlignment(Pos.CENTER);


        this.getChildren().addAll(chooseLBL, HVBox, desLBL, inputBox, btnBox);
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

    public boolean checkDate(String s){
        if(s.length()!=10)
            return false;
        return (Character.isDigit(s.charAt(0)) && Character.isDigit(s.charAt(1)) &&
                Character.isDigit(s.charAt(2)) && Character.isDigit(s.charAt(3))
                && s.charAt(4)=='-' && Character.isDigit(s.charAt(5)) && Character.isDigit(s.charAt(6))
                && s.charAt(7)=='-' && Character.isDigit(s.charAt(8)) && Character.isDigit(s.charAt(9)));

    }

    public TextField getTextField1() {
        return textField1;
    }

    public Label getLabel1() {
        return label1;
    }

    public static void getLastTenOrders(String cID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/dbproject",
                            "root", "fsg138099");
            CallableStatement callableStat1;
            callableStat1 = mysqlConnection.prepareCall("{call getlasttenorder(?)}");
            callableStat1.setString(1, cID);
            callableStat1.execute();
            ResultSet rs = callableStat1.getResultSet();
            while (rs.next()){
                list.add(new Product (rs.getInt("idOrders"),
                        rs.getInt("idProduct"),
                        rs.getInt("price"),
                        rs.getString("type_name")
                        ,rs.getString("f_date")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void getProducts(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/dbproject",
                            "root", "fsg138099");
            CallableStatement callableStat1;
            callableStat1 = mysqlConnection.prepareCall("{call getProducts()}");
            callableStat1.execute();
            ResultSet rs = callableStat1.getResultSet();
            while (rs.next()){
                listgold.add(new gold(rs.getString("type_name"),rs.getString("country"),
                        rs.getFloat("discount"),rs.getInt("price"),
                        rs.getFloat("weight"),rs.getInt("idProduct")) );
            }
            callableStat1.getMoreResults();
            ResultSet rs2 = callableStat1.getResultSet();
            while (rs2.next()){
                listjewerly.add(new jewellery(rs2.getString("type_name"),
                        rs2.getString("country"),rs2.getFloat("discount"),
                        rs2.getInt("price"),rs2.getFloat("weight"),
                        rs2.getInt("idProduct")));
            }
            callableStat1.getMoreResults();
            ResultSet rs3 = callableStat1.getResultSet();
            while (rs3.next()){
                listcoin.add(new Coins(rs3.getString("type_name"),rs3.getFloat("discount")
                        ,rs3.getInt("price"),rs3.getFloat("weight")
                        ,rs3.getInt("C_year")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public TextField getTextField2() {
        return textField2;
    }
     public Label getLabel2() {
        return label2;
    }
}
