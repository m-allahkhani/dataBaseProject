package DataBaseProject.controller;
import DataBaseProject.Model.ConnectData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import DataBaseProject.view.IDEpage;

import javax.swing.text.TabableView;
import java.io.*;
import java.sql.*;
import java.util.List;

public class IDEpageController {
    private IDEpage idEpage;
    private Stage primaryStage;
    private String type;
    private File file;
    private StringWriter stringWriter;
    private String[] columns;
    private ConnectData connectData;



    public IDEpageController(Stage primaryStage, String type, File file){
        this.primaryStage = primaryStage;
        this.file = file;
        this.type = type;
        idEpage = new IDEpage();
        columns = new String[20];
        connectData = new ConnectData();

        primaryStage.setScene(new Scene(idEpage));

        primaryStage.close();
        primaryStage.show();

        if (type.equals("file")){
            stringWriter = printFile();
            idEpage.getWriteTF().setText(stringWriter.toString());
            idEpage.getWriteTF().setDisable(true);
        }
        checkRunBTN();
        checkStartBTN(primaryStage);
        checkExitBTN(primaryStage);

    }

    private void checkExitBTN(final Stage primaryStage){
        idEpage.getExitBTN().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });
    }

    private void checkStartBTN(final Stage stage){
        idEpage.getStartBTN().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePageController  controller = new ChoosePageController(stage);

            }
        });
    }



    private void checkRunBTN(){
        idEpage.getRunBTN().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // updateColumns(columns);
               // updateTable();
                idEpage.setNewTable();
                if ("file".equals(type)) {
                    if(isSElect(stringWriter)) {
                        List listData = connectData.getData(columns, stringWriter.toString());
                        connectData.SetDataOnTable(idEpage.getTable(), listData, columns);
                    }
                    else {
                        connectData.setData(stringWriter.toString(), idEpage.getResultLable());
                    }
                }
                else if ("write".equals(type)) {
                    stringWriter = readCode(); //query
                    if (isSElect(stringWriter)){
                        List listData = connectData.getData(columns, stringWriter.toString());
                        connectData.SetDataOnTable(idEpage.getTable(), listData, columns);
                    }
                    else {
                        connectData.setData(stringWriter.toString(), idEpage.getResultLable());
                    }

                }
            }
        });
    }


    private StringWriter printFile(){
        int columnNum = 0;// the number of columns list head
        StringWriter stringWriter = new StringWriter();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            String str = null;
            try {
                str = bufferedReader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (str == null) {
                break;
            } else {
                stringWriter.write(str + "\n");
                String[] split = str.split(" ");
                columnNum = checkCloumnName(split, columnNum);
            }

        }
        return stringWriter;
    }

    private StringWriter readCode() {
        int columnNum = 0; // the number of columns list head
        BufferedReader stringReader = new BufferedReader(new StringReader(idEpage.getWriteTF().getText()));
        StringWriter stringWriter = new StringWriter();

        while (true) {

            String str = null;
            try {
                str = stringReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (str == null) {
                try {
                    stringReader.close();
                    stringWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                stringWriter.write(str + "\n");
            }
        }
        String[] split =stringWriter.toString().split(" ");
        columnNum = checkCloumnName(split, columnNum);
        return stringWriter;
    }

    private void updateColumns(String[] columns){
            //for a new query: we need a clean list for  names of columns
            for (int i = 0; i < 20; i++){
                if (columns != null){
                    columns[i] = null;
                }
            }
        }

    private int checkCloumnName(String[] split, int num){
        split = deleteSpace(split);
        if (!split[0].equalsIgnoreCase("select")){
            return num;
        }
        for (int i = 1; i < split.length; i++){
            if(split[i].equalsIgnoreCase("from")){
                break;
            }
            if (!split[i].equals(",")){
                if(split[i].endsWith(",")){
                  String[] str  = split[i].split(",");
                    columns[num] = str[0];
                    num++;
                }
                else if (i < split.length - 1 && split[i+1].equalsIgnoreCase("as")){
                    i++;
                }
                else {
                    columns[num] = split[i];
                    num++;
                }

            }
        }

        return num;
    }

    public String[] deleteSpace(String[] split){
        //remove spases from split array

        while (true){

            for(int i = 0; i < split.length - 1; i++){
                if (split[i].equals("") && !split[i + 1].equals("")){

                    String tmp = split[i];
                    split[i] = split [i + 1];
                    split[i + 1] = tmp;
                }
            }

            int checkN = 0;

            for (int i = 0; i < split.length - 1; i++){
                if (split[i].equals("") && !split[i + 1].equals("")){
                    checkN++;
                }
            }
            if (checkN == 0){
                break;
            }
        }
        return split;
    }

    private boolean isSElect(StringWriter writer){
        String[] str = stringWriter.toString().split(" ");
        str = deleteSpace(str);
        return str[0].equalsIgnoreCase("select");

    }

}


