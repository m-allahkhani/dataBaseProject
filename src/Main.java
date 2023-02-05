import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws InterruptedException{
        primaryStage.setWidth(1550);
        primaryStage.setHeight(830);
        ChoosePageController pageController = new ChoosePageController(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
