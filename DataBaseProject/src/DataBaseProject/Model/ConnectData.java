package DataBaseProject.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectData {

    public void setData(String query, Label label){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject", "root", "Fa9922762208");
            Statement statement = connection.createStatement();
             statement.executeUpdate(query);
             label.setText("the query executed.");
        }
        catch (SQLException e){
            label.setText(e.getMessage());
        }
    }


    public List getData (String[] columns, String query){
        List<String> dataList = new ArrayList<String>();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject", "root", "Fa9922762208");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

           //get data from mysql and save in a list as data list
            while (resultSet.next()){
                String str = "";
                for(int i = 0; i <columns.length; i++){
                    if (columns[i] == null){
                        break;
                    }
                     str = str + resultSet.getString(columns[i] ) + ",";

                }
                dataList.add(str);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return dataList;
    }

    public void  SetDataOnTable(TableView table, List dataList, String[] columnNames){
        //show data in the table view in ide page
        /*table.getColumns().removeAll();
        table.getItems().removeAll();*/
        //TODO how to remove columns from to tables

        for (int i = 0; i < columnNames.length; i++){
            if (columnNames[i] == null){
                break;
            }
            TableColumn<String, String> column = new TableColumn<>(columnNames[i]);
            table.getColumns().add(column);

            column.setCellValueFactory(cellDataFeatures -> {
                String values = cellDataFeatures.getValue();
                String[] cells = values.split(",");
                int columnIndex = cellDataFeatures.getTableView().getColumns().indexOf(cellDataFeatures.getTableColumn());
                SimpleStringProperty stringProperty;
                if(columnIndex >= cells.length) {
                    stringProperty = new SimpleStringProperty("");
                }
                else {
                    stringProperty = new SimpleStringProperty(cells[columnIndex]);
                }
                return stringProperty;
            });
            table.setItems(FXCollections.observableList(dataList));

        }
    }

    public void  SetDataOnTableLTorder(TableView table, List dataList, String[] columnNames){
        for (int i = 0; i < 5; i++){
            if (columnNames[i] == null){
                break;
            }
            TableColumn<String, String> column = new TableColumn<>(columnNames[i]);
            table.getColumns().add(column);

            column.setCellValueFactory(cellDataFeatures -> {
                String values = cellDataFeatures.getValue();
                String[] cells = values.split(",");
                int columnIndex = cellDataFeatures.getTableView().getColumns().indexOf(cellDataFeatures.getTableColumn());
                SimpleStringProperty stringProperty;
                if(columnIndex >= cells.length) {
                    stringProperty = new SimpleStringProperty("");
                }
                else {
                    stringProperty = new SimpleStringProperty(cells[columnIndex]);
                }
                return stringProperty;
            });
            table.setItems(FXCollections.observableList(dataList));
        }
    }

    public void  SetDataOnTableProducts(TableView tablegold,TableView tablejewerly,
                                        TableView tablecoin,List dataListgold,
                                        List dataListjewerly,List dataListcoin){
        String[] columnsCoin={"type_name","C_year","weight","price","discount"};
        String[] columnsGold={"type_name","idProduct","weight","country","price","discount"};
        String[] columnsJewerly={"type_name","idProduct","weight","country","price","discount"};
        for (int i = 0; i < 6; i++){
            if (columnsGold[i] == null){
                break;
            }
            TableColumn<String, String> columng = new TableColumn<>(columnsGold[i]);
            tablegold.getColumns().add(columng);

            columng.setCellValueFactory(cellDataFeatures -> {
                String values = cellDataFeatures.getValue();
                String[] cells = values.split(",");
                int columnIndex = cellDataFeatures.getTableView().getColumns().indexOf(cellDataFeatures.getTableColumn());
                SimpleStringProperty stringProperty;
                if(columnIndex >= cells.length) {
                    stringProperty = new SimpleStringProperty("");
                }
                else {
                    stringProperty = new SimpleStringProperty(cells[columnIndex]);
                }
                return stringProperty;
            });
            tablegold.setItems(FXCollections.observableList(dataListgold));
        }

        for (int i = 0; i < 6; i++){
            if (columnsJewerly[i] == null){
                break;
            }
            TableColumn<String, String> columnj = new TableColumn<>(columnsJewerly[i]);
            tablejewerly.getColumns().add(columnj);

            columnj.setCellValueFactory(cellDataFeatures -> {
                String values = cellDataFeatures.getValue();
                String[] cells = values.split(",");
                int columnIndex = cellDataFeatures.getTableView().getColumns().indexOf(cellDataFeatures.getTableColumn());
                SimpleStringProperty stringProperty;
                if(columnIndex >= cells.length) {
                    stringProperty = new SimpleStringProperty("");
                }
                else {
                    stringProperty = new SimpleStringProperty(cells[columnIndex]);
                }
                return stringProperty;
            });
            tablejewerly.setItems(FXCollections.observableList(dataListjewerly));
        }

        for (int i = 0; i < 5; i++){
            if (columnsCoin[i] == null){
                break;
            }
            TableColumn<String, String> columnc = new TableColumn<>(columnsJewerly[i]);
            tablecoin.getColumns().add(columnc);

            columnc.setCellValueFactory(cellDataFeatures -> {
                String values = cellDataFeatures.getValue();
                String[] cells = values.split(",");
                int columnIndex = cellDataFeatures.getTableView().getColumns().indexOf(cellDataFeatures.getTableColumn());
                SimpleStringProperty stringProperty;
                if(columnIndex >= cells.length) {
                    stringProperty = new SimpleStringProperty("");
                }
                else {
                    stringProperty = new SimpleStringProperty(cells[columnIndex]);
                }
                return stringProperty;
            });
            tablecoin.setItems(FXCollections.observableList(dataListcoin));
        }
    }

    public List getDataproducts (){
        String[] columnsCoin={"type_name","C_year","weight","price","discount"};
        String[] columnsGold={"type_name","idProduct","weight","country","price","discount"};
        String[] columnsJewerly={"type_name","idProduct","weight","country","price","discount"};
        List <List> lists=new ArrayList<>();
        List<String> goldList = new ArrayList<String>();
        List<String> jewerlyList = new ArrayList<String>();
        List<String> coinList = new ArrayList<String>();
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
                String str = "";
                for(int i = 0; i < 6; i++){
                    if (columnsGold[i] == null){
                        break;
                    }
                    str = str +rs.getString(columnsGold[i] ) + ",";
                }
                goldList.add(str);
            }
            callableStat1.getMoreResults();
            ResultSet rs2 = callableStat1.getResultSet();
            while (rs2.next()){
                String str = "";
                for(int i = 0; i < 6; i++){
                    if (columnsJewerly[i] == null){
                        break;
                    }
                    str = str +rs2.getString(columnsJewerly[i] ) + ",";
                }
                jewerlyList.add(str);
            }
            callableStat1.getMoreResults();
            ResultSet rs3 = callableStat1.getResultSet();
            while (rs3.next()){
                String str = "";
                for(int i = 0; i <5; i++){
                    if (columnsCoin[i] == null){
                        break;
                    }
                    str = str +rs3.getString(columnsCoin[i] ) + ",";
                }
                coinList.add(str);
            }
            lists.add(goldList);
            lists.add(jewerlyList);
            lists.add(coinList);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public List getDataLastTenOrder (String cid){
        List<String> dataList = new ArrayList<String>();
        String[] columns={"type_name","idProduct","price","idOrders","f_date"};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/DBproject",
                            "root", "M.A.Toopkanlu");
            CallableStatement callableStat1;
            callableStat1 = mysqlConnection.prepareCall("{call getlasttenorder(?)}");
            callableStat1.setString(1,cid);
            callableStat1.execute();
            ResultSet rs = callableStat1.getResultSet();
            while (rs.next()){
                String str = "";
                for(int i = 0; i < 5; i++){
                    if (columns[i] == null){
                        break;
                    }
                    str = str +rs.getString(columns[i] ) + ",";
                }
                dataList.add(str);
            }

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public List getDatabestseller (String start,String end){
        List<String> dataList = new ArrayList<String>();
        String[] columns={"type_name","idProduct","count","price"};
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
                String str = "";
                for(int i = 0; i < 4; i++){
                    if (columns[i] == null){
                        break;
                    }
                    str = str +rs.getString(columns[i] ) + ",";
                }
                dataList.add(str);
            }

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataList;
    }

}
