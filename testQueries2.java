package src;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class testQueries2 extends Application implements Initializable {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("getlasttenorder.fxml"));
            Scene scene = new Scene(root, 760, 484);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        @FXML
        public TableView<Product> tableview_bestseller;
        public TableColumn<Product,String> col_typename;
        public TableColumn<Product,Integer> col_idProduct;
        public TableColumn<Product, String> col_f_date;
        public TableColumn<Product,Integer> col_price;
        public  TableColumn<Product,Integer> col_idOrder;
        ObservableList<Product> list = FXCollections.observableArrayList();
        String cID="1131100000";

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
            getLastTenOrders(cID);
            col_f_date.setCellValueFactory(new PropertyValueFactory<Product,String>("f_date"));
            col_typename.setCellValueFactory(new PropertyValueFactory<Product,String>("type_name"));
            col_idProduct.setCellValueFactory(new PropertyValueFactory<Product,Integer>("idProduct"));
            col_idOrder.setCellValueFactory(new PropertyValueFactory<Product,Integer>("idOrders"));
            col_price.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
            tableview_bestseller.setItems(list);
        }


        public void getLastTenOrders(String cID){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection mysqlConnection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/DBproject",
                                "root", "M.A.Toopkanlu");
                CallableStatement callableStat1;
                callableStat1 = mysqlConnection.prepareCall("{call getlasttenorder(?)}");
                callableStat1.setString(1, cID);
                callableStat1.execute();
                ResultSet rs = callableStat1.getResultSet();
                while (rs.next()){
                    list.add(new Product(rs.getInt("idProduct"),
                            rs.getInt("price"),
                            rs.getInt("idOrders"),
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
}
