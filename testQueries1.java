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

public class testQueries1 extends Application implements Initializable {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("getbestseller.fxml"));
        Scene scene = new Scene(root, 760, 484);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public TableView<Product> tableview_bestseller;
    public TableColumn<Product,String> col_typename;
    public TableColumn<Product,Integer> col_idProduct;
    public TableColumn<Product,Integer> col_count;
    public TableColumn<Product,Integer> col_price;
    public  TableColumn<Product,Integer> col_idOrder;
    ObservableList<Product> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        showBestseller("1400-01-01","1401-12-30");
        col_count.setCellValueFactory(new PropertyValueFactory<Product,Integer>("count"));
        col_typename.setCellValueFactory(new PropertyValueFactory<Product,String>("type_name"));
        col_idProduct.setCellValueFactory(new PropertyValueFactory<Product,Integer>("idProduct"));
        col_idOrder.setCellValueFactory(new PropertyValueFactory<Product,Integer>("idOrders"));
        col_price.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        tableview_bestseller.setItems(list);
    }

    public void showBestseller(String start,String end){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/DBproject",
                            "root", "M.A.Toopkanlu");
            CallableStatement callableStat1;
            callableStat1 = mysqlConnection.prepareCall("{call bestSeller(?,?)}");
            callableStat1.setString(1, start);
            callableStat1.setString(2, end);
            callableStat1.execute();
            ResultSet rs = callableStat1.getResultSet();
            while (rs.next()){
                list.add(new Product(rs.getInt("idProduct"),
                        rs.getInt("price"),
                        rs.getInt("idOrders"),
                        rs.getString("type_name")
                        ,rs.getInt("count")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
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
