package src;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class login extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_login.fxml"));
        Scene scene = new Scene(root, 760, 484);
        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    void signUpPressed(ActionEvent event)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("register");
            stage.setScene(new Scene(root1,412,635));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  TextField userNameTextField;
    public TextField passWordTextField;
    public ComboBox typeComboBox;
    @FXML
    void sendLoginPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
        String username=userNameTextField.getText();
        String password=passWordTextField.getText();
        String type= (String) typeComboBox.getValue();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection mysqlConnection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/DBproject",
                "root","M.A.Toopkanlu");
        CallableStatement callableStat;
        if(username.length()>20 || username.length()==0 ||
                password.length()==0 || password.length()>30 || type.equals("User type")){
            alert.setHeaderText("Invalid input!");
            alert.showAndWait();
            userNameTextField.clear();
            passWordTextField.clear();
        }else if(type.equals("Customer")){
            callableStat=mysqlConnection.prepareCall("{call findCustomer(?,?)}");
            callableStat.setString(1,username);
            callableStat.setString(2,password);
            callableStat.execute();
            ResultSet rs = callableStat.getResultSet();
            if(!rs.next()){
                alert.setHeaderText("Can not find customer!");
                alert.showAndWait();
                userNameTextField.clear();
                passWordTextField.clear();
            }else {
                do{
                    String customerId = rs.getString("idCustomer");
                    String customerName = rs.getString("city");
                    System.out.println("id is " + customerId);
                    // other attributes of customer can be here ...
                }while (rs.next());
            }
        }else {
            callableStat=mysqlConnection.prepareCall("{call findAdmin(?,?)}");
            callableStat.setString(1,username);
            callableStat.setString(2,password);
            callableStat.execute();
            ResultSet rs = callableStat.getResultSet();
            if(!rs.next()){
                alert.setHeaderText("Can not find site admin!");
                alert.showAndWait();
                userNameTextField.clear();
                passWordTextField.clear();
            }else {
                do{
                    String adminId = rs.getString("idStaff");
                    System.out.println("id is " + adminId);
                    // other attributes of customer can be here ...
                }while (rs.next());
            }
        }
    }
}
