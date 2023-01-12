package DataBaseProject.controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import DataBaseProject.view.IDEpage;

import java.io.*;

public class IDEpageController {
    private IDEpage idEpage;
    private Stage primaryStage;
    private String type;
    private File file;



    public IDEpageController(Stage primaryStage, String type, File file){
        this.primaryStage = primaryStage;
        this.file = file;
        this.type = type;
        idEpage = new IDEpage();
        primaryStage.setScene(new Scene(idEpage));

        primaryStage.close();
        primaryStage.show();

        if (type.equals("file")){
            idEpage.getWriteTF().setText(printFile().toString());
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
            }
        });
    }


    private StringWriter printFile(){

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
            }

        }
        return stringWriter;
    }
}


