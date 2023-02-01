package DataBaseProject.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectData {

    public List getData (String[] columns, String query){
        List<String> dataList = new ArrayList<String>();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject", "root", "Fa9922762208");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

           //get data from mysql and save in a list as data list
            while (resultSet.next()){
                String str = "";
                for(int i = 0; i < 20; i++){
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

        for (int i = 0; i < 20; i++){
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

}
