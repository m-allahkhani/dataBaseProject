package DataBaseProject.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import DataBaseProject.view.QueryPage;

public class QueryPageController {

    QueryPage queryPage;

    public QueryPageController(Stage primaryStage){

        queryPage = new QueryPage();
        primaryStage.setScene(new Scene(queryPage));

        primaryStage.close();
        primaryStage.show();

        checkBackBtn(primaryStage);
        checkExitBtn(primaryStage);
        //TODO
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


}
