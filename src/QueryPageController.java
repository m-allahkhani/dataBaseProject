import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;


public class QueryPageController {

    QueryPage queryPage;
    ConnectData connectData;

    public QueryPageController(Stage primaryStage){

        queryPage = new QueryPage();
        primaryStage.setScene(new Scene(queryPage));

        primaryStage.close();
        primaryStage.show();

        connectData = new ConnectData();

        checkBackBtn(primaryStage);
        checkExitBtn(primaryStage);
        for (int i = 0; i < 18; i++){
            checkQueryBtn(i);
        }

    }

    private void checkExitBtn(final Stage stage){
        queryPage.getExitBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

    }

    private void checkBackBtn(final Stage stage){
        queryPage.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePageController controller = new ChoosePageController(stage);
            }
        });

    }

    private void checkQueryBtn(int i ){
        queryPage.getBtn(i).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(i==4){//query 5
                    String startDate = queryPage.getTextField1().getText();
                    String finishDate = queryPage.getTextField2().getText();
                    String str = "select  idFactor,idCustomer,price,discount,F_date \n" +
                            "from factor\n" +
                            "where "+startDate+"<F_date<"+finishDate+"\n" +
                            "group by idCustomer \n" +
                            "having sum(price-price*discount)>some(\t\n" +
                            "\t\t\t\t\tselect sum(price) \n" +
                            "\t\t\t\t\tfrom factor as f\n" +
                            "                    where factor.idCustomer <> f.idCustomer\n" +
                            "\t\t\t\t\tgroup by idCustomer \n" +
                            "                    )\n" +
                            "limit 10\n";
                    System.out.println(str);
                    String[] strings = {"idFactor","idCustomer", "price", "discount", "F_date"};
                    TableView tableView = new TableView();
                    tableView.setPrefHeight(400);
                    tableView.setPrefWidth(800);
                    List list1 = connectData.getData(strings, str);
                    connectData.SetDataOnTable(tableView, list1, strings);
                    VBox vBox = new VBox(new HBox(tableView));
                    vBox.getChildren().addAll(tableView);
                    BackgroundImage backgroundImage = new BackgroundImage(new Image(QueryPage
                            .class.getResourceAsStream("image2.png")),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT
                    );
                    vBox.setBackground(new Background(backgroundImage));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(vBox));
                    stage.show();




                }
                if(i==14){//query 15
                    String startDate = queryPage.getTextField1().getText();
                    String finishDate = queryPage.getTextField2().getText();
                    String str = "select count(*) \n" +
                            "from  pricerecord \n" +
                            "where "+startDate+"<= PR_date <="+finishDate+" and idProduct="+"1234" ;
                    System.out.println(str);
                    String[] strings = {"count(*)"};
                    TableView tableView = new TableView();
                    tableView.setPrefHeight(400);
                    tableView.setPrefWidth(800);
                    List list1 = connectData.getData(strings, str);
                    connectData.SetDataOnTable(tableView, list1, strings);
                    VBox vBox = new VBox(new HBox(tableView));
                    vBox.getChildren().addAll(tableView);
                    BackgroundImage backgroundImage = new BackgroundImage(new Image(QueryPage
                            .class.getResourceAsStream("image2.png")),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT
                    );
                    vBox.setBackground(new Background(backgroundImage));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(vBox));
                    stage.show();




                }
                if(i == 11){
                    queryPage.getDescribe().setText("Display the list of users");
                    DisplayTheListOfUsers  displayTheListOfUsers = new DisplayTheListOfUsers();
                    Stage stage = new Stage();
                    String str1 = "select customer.idCustomer, city, street, phone_number,service_date  from customer, customerinperson where customer.idCustomer = customerinperson.idcustomer;";
                    String str2 =  "select customer.idCustomer, city, street, phone_number,email, userName, pass as password, postal_code   from customer, onlinecustomer where customer.idCustomer = onlinecustomer.idcustomer;"; // num2
                    String[] strings1 = {"idCustomer", "city", "street", "phone_number","service_date"};
                    String[] strings2 = {"idCustomer", "city", "street", "phone_number","email", "userName", "password", "postal_code" };
                    List list1 = connectData.getData(strings1, str1);
                    connectData.SetDataOnTable(displayTheListOfUsers.getInprder(), list1, strings1);
                    List list2 = connectData.getData(strings2, str2);
                    connectData.SetDataOnTable(displayTheListOfUsers.getOnline(), list2,strings2);
                    stage.setScene(new Scene(displayTheListOfUsers));
                    stage.show();

                }
                if(i == 16){
                    String cityName = queryPage.getTextField1().getText();
                    String str = "select idcustomer, street, province, phone_number from customer where city = \""+ cityName +"\";";
                    System.out.println(str);
                    String[] strings = {"idcustomer", "street", "province", "phone_number"};
                    TableView tableView = new TableView();
                    tableView.setPrefHeight(400);
                    tableView.setPrefWidth(800);
                    List list1 = connectData.getData(strings, str);
                    connectData.SetDataOnTable(tableView, list1, strings);
                    VBox vBox = new VBox(new HBox(tableView));
                    vBox.getChildren().addAll(tableView);
                    BackgroundImage backgroundImage = new BackgroundImage(new Image(QueryPage
                            .class.getResourceAsStream("image2.png")),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT
                    );
                    vBox.setBackground(new Background(backgroundImage));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(vBox));
                    stage.show();

                }
                if(i == 6){
                    String str1 = "select product.idProduct as GoldId, product.discount as discount, product.price as price, purity, weight, country " +
                            "from product, gold " +
                            "where gold.idProduct = product.idProduct and discount > .15;" ;// num7
                    String str2 = "select product.idProduct as CoinId, product.discount as discount, product.price as price, C_year, weight " +
                            "from product, coins " +
                            "where coins.idProduct = product.idProduct and discount > .15;";//num7

                    String str3 = "select product.idProduct as JewleryID, product.discount as discount, product.price as price, making_charge, weight, country " +
                            "from product, jewlery " +
                            "where jewlery.idProduct = product.idProduct and discount > .15;";

                    String[] strings1 = {"GoldId", "discount", "price", "purity", "weight", "country"};
                    String[] strings2 = {"CoinId", "discount", "price", "C_year", "weight" };
                    String[] strings3 = {"JewleryID", "discount","price", "making_charge", "weight", "country"};

                    Label label1 = new Label("gold");
                    Label label2 = new Label("Coins");
                    Label label = new Label("Jewlery");

                    TableView tableView1 = new TableView();
                    TableView tableView2 = new TableView();
                    TableView tableView3 = new TableView();
                    tableView1.setPrefWidth(400);
                    tableView2.setPrefWidth(400);
                    tableView3.setPrefWidth(400);
                    tableView1.setPrefHeight(200);
                    tableView2.setPrefHeight(200);
                    tableView3.setPrefHeight(200);

                    List list1 = connectData.getData(strings1, str1);
                    connectData.SetDataOnTable(tableView1, list1, strings1);
                    List list2 = connectData.getData(strings2, str2);
                    connectData.SetDataOnTable(tableView2, list2, strings2);
                    List list3 = connectData.getData(strings3, str3);
                    connectData.SetDataOnTable(tableView3, list3, strings3);

                    VBox vBox = new VBox(label1, tableView1, label2, tableView2, label, tableView3);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(vBox));

                    BackgroundImage backgroundImage = new BackgroundImage(new Image(QueryPage
                            .class.getResourceAsStream("image2.png")),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT
                    );
                    vBox.setBackground(new Background(backgroundImage));

                    stage.show();


                }
            }

        });

    }


}
