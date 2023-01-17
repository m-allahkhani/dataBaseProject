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

public class testQueries3 extends Application implements Initializable {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("getproducts.fxml"));
        Scene scene = new Scene(root, 724, 705);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public TableView <gold> gold_tableview;
    public TableColumn<gold,String> gold_col_type_name;
    public TableColumn<gold,String> gold_col_country;
    public TableColumn<gold,Integer> gold_col_idProduct;
    public TableColumn<gold,Float> gold_col_weight;
    public TableColumn<gold,Integer> gold_col_price;
    public TableColumn<gold,Float> gold_col_discount;
    public TableView <jewellery> jewerly_tableview;
    public TableColumn<jewellery,String> jewerly_col_type_name;
    public TableColumn<jewellery,Integer> jewerly_col_idProduct;
    public TableColumn<jewellery,Float> jewerly_col_weight;
    public TableColumn<jewellery,Integer> jewerly_col_price;
    public TableColumn<jewellery,String> jewerly_col_country;
    public TableColumn<jewellery,Float> jewerly_col_discount;
    public TableView <Coins> coin_tableview;
    public TableColumn<Coins,String> coin_col_type_name;
    public TableColumn<Coins,Integer> coin_col_year;
    public TableColumn<Coins,Integer> coin_col_price;
    public TableColumn<Coins,Float> coin_col_discount;
    public TableColumn<Coins,Float> coin_col_weight;

    ObservableList<gold> listgold = FXCollections.observableArrayList();
    ObservableList<jewellery> listjewerly = FXCollections.observableArrayList();
    ObservableList<Coins> listcoin = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        getProducts();
        gold_col_type_name.setCellValueFactory(new PropertyValueFactory<gold,String>("type_name"));
        gold_col_country.setCellValueFactory(new PropertyValueFactory<gold,String>("country"));
        gold_col_idProduct.setCellValueFactory(new PropertyValueFactory<gold,Integer>("idProduct"));
        gold_col_price.setCellValueFactory(new PropertyValueFactory<gold,Integer>("price"));
        gold_col_discount.setCellValueFactory(new PropertyValueFactory<gold,Float>("discount"));
        gold_col_weight.setCellValueFactory(new PropertyValueFactory<gold,Float>("weight"));
        gold_tableview.setItems(listgold);

        jewerly_col_type_name.setCellValueFactory(new PropertyValueFactory<jewellery,String>("type_name"));
        jewerly_col_country.setCellValueFactory(new PropertyValueFactory<jewellery,String>("country"));
        jewerly_col_idProduct.setCellValueFactory(new PropertyValueFactory<jewellery,Integer>("idProduct"));
        jewerly_col_price.setCellValueFactory(new PropertyValueFactory<jewellery,Integer>("price"));
        jewerly_col_discount.setCellValueFactory(new PropertyValueFactory<jewellery,Float>("discount"));
        jewerly_col_weight.setCellValueFactory(new PropertyValueFactory<jewellery,Float>("weight"));
        jewerly_tableview.setItems(listjewerly);

        coin_col_type_name.setCellValueFactory(new PropertyValueFactory<Coins,String>("type_name"));
        coin_col_year.setCellValueFactory(new PropertyValueFactory<Coins,Integer>("C_year"));
        coin_col_price.setCellValueFactory(new PropertyValueFactory<Coins,Integer>("price"));
        coin_col_discount.setCellValueFactory(new PropertyValueFactory<Coins,Float>("discount"));
        coin_col_weight.setCellValueFactory(new PropertyValueFactory<Coins,Float>("weight"));
        coin_tableview.setItems(listcoin);
    }
    public void getProducts(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/DBproject",
                            "root", "M.A.Toopkanlu");
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


}
