package DataBaseProject.controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import DataBaseProject.view.IDEpage;

import java.io.*;
import java.sql.*;

public class IDEpageController {
    private IDEpage idEpage;
    private Stage primaryStage;
    private String type;
    private File file;
    private StringWriter stringWriter;
    private String[] columns;



    public IDEpageController(Stage primaryStage, String type, File file){
        this.primaryStage = primaryStage;
        this.file = file;
        this.type = type;
        idEpage = new IDEpage();
        columns = new String[20];
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
                //TODO
                idEpage.getResult().setText("");//refresh
                idEpage.getResult().setDisable(true);
                updateColumns(columns);
                if ("file".equals(type)) {
                    //scanFile
                    StringWriter writer = connectData(columns, stringWriter.toString());
                    idEpage.getResult().setText(writer.toString());
                    idEpage.getResult().setDisable(false);
                }
                else if ("write".equals(type)) {
                    stringWriter = readCode();
                    StringWriter writer = connectData(columns, stringWriter.toString());
                    idEpage.getResult().setText(writer.toString());
                    idEpage.getResult().setDisable(false);
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
                String[] split = str.split(" ");
                columnNum = checkCloumnName(split, columnNum);

            }
        }
        return stringWriter;
    }

    private StringWriter connectData(String[] columns, String query){
        StringWriter writer = new StringWriter();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject", "root", "Fa9922762208");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            for (int i = 0; i < 20; i++){
                if (columns[i] == null){
                    break;
                }
                writer.write(columns[i] + "  ");
            }
            writer.write("\n");
            while (resultSet.next()){
                for(int i = 0; i < 20; i++){
                    if (columns[i] == null){
                        break;
                    }
                   String str = resultSet.getString(columns[i]);
                   writer.write(str + "\n");

                }

            }
            try {
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return writer;
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
                columns[num] = split[i];
                num++;
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

}


