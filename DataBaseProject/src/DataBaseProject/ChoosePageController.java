package DataBaseProject.controller;

import DataBaseProject.view.*;

import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class ChoosePageController {

    private ChoosePage choosePage;
    private Stage primaryStage;
    private File file = null;
    private boolean fileBtn, writeBtn, queryBtn;

    public ChoosePageController(Stage primaryStage){

        this.primaryStage = primaryStage;
        choosePage = new ChoosePage();
        primaryStage.setScene(new Scene(choosePage));

        fileBtn  = false;
        writeBtn = false;
        queryBtn = false;



        primaryStage.close();
        primaryStage.show();

        checkSubmitBTN();
    }

    public ChoosePage getChoosePage(){
        return  choosePage;
    }

    private void  fileBtnAction(){
        choosePage.getFileBTN().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                fileBtn = fileBtn? false: true;
            }
        });
    }

    private void writeBtnAction(){

        choosePage.getWriteBTN().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writeBtn = writeBtn? false: true;
            }
        });

    }

    private void queryBtnAction(){
        choosePage.getShowTheQuery().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryBtn = queryBtn? false: true;
            }
        });
    }

    private boolean checkPath(){

        String path = getChoosePage().getPathTF().getText();
        file = new File(path);

        if(file.isFile() && file.exists()){
            return true;
        }
        else {
            return false;
        }

    }

    public void checkSubmitBTN() {
        writeBtnAction();
        fileBtnAction();
        queryBtnAction();

        choosePage.getSubmitBTN().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if ((fileBtn && writeBtn) || (fileBtn && queryBtn) || (writeBtn && queryBtn)){
                    choosePage.getErrorLBL().setText("Please choose one options!");
                    choosePage.getErrorLBL().setTextFill(Color.RED);
                }
                else if (!fileBtn && !writeBtn && !queryBtn){
                    choosePage.getErrorLBL().setText("Please choose a options!");
                    choosePage.getErrorLBL().setTextFill(Color.RED);
                }
                else if(fileBtn && !getChoosePage().getPathTF().getText().equals("")){
                    if (checkPath()){
                        IDEpageController idEpageCtrl = new IDEpageController(
                                primaryStage, "file", file
                        );
                    }
                    else{
                        choosePage.getErrorLBL().setText("The path is not valid!");
                        choosePage.getErrorLBL().setTextFill(Color.RED);
                    }
                }
                else if ( fileBtn && getChoosePage().getPathTF().getText().equals("")){
                    choosePage.getErrorLBL().setText("Please enter the path of file!");
                    choosePage.getErrorLBL().setTextFill(Color.RED);
                }
                else if(writeBtn){
                    IDEpageController idEpageCntrl = new IDEpageController(primaryStage, "write", file);
                }
                else {
                    QueryPageController controller = new QueryPageController(primaryStage);
                    //TODO
                }
            }
        });
    }

    public File getFile(){return  file;}






}
