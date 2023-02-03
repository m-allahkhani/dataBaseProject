package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.*;
import src.controller.ChoosePageController;


public class login extends Application {
    static Stage stage=null;
    static String CustomerID;
    static String AdminID;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_login.fxml"));
        Scene scene = new Scene(root, 760, 484);
        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        stage=primaryStage;
        primaryStage.show();
    }

    public TextField userNameSiTextField;
    public TextField emailSiTextField;
    public  TextField phoneNumSiTextField;
    public TextField provinceSiTextField;
    public TextField streetSiTextField;
    public TextField passwordSiTextField;
    public TextField citySiTextField;
    public TextField postalCodeTextField;

    @FXML
    void signUpPressed(ActionEvent event)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage registerationStage= new Stage();
            registerationStage.setTitle("register");
            registerationStage.setScene(new Scene(root1,412,635));
            registerationStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  TextField userNameTextField;
    public TextField passWordTextField;
    public ComboBox typeComboBox;
    @FXML
    void RegisterPressed(ActionEvent event) {
        String username=userNameSiTextField.getText();
        String password=passwordSiTextField.getText();
        String email=emailSiTextField.getText();
        String city=citySiTextField.getText();
        String street=streetSiTextField.getText();
        String province=provinceSiTextField.getText();
        String phoneNum=phoneNumSiTextField.getText();
        String postalCode=postalCodeTextField.getText();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        if(phoneNum.length()!=11 || province.length()==0 || street.length()==0
                || city.length()==0 || email.length()==0 || email.length()>30
                || username.length()>20 || username.length()==0 ||
                password.length()==0 || password.length()>30 ||
                postalCode.length()!=10 || city.length()> 40 ||
                province.length()> 40 || street.length()> 40){
            alert.setHeaderText("Invalid input!");
            alert.showAndWait();
            userNameSiTextField.clear();
            passwordSiTextField.clear();
            emailSiTextField.clear();
            citySiTextField.clear();
            streetSiTextField.clear();
            provinceSiTextField.clear();
            phoneNumSiTextField.clear();
            postalCodeTextField.clear();
        }
        else {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection mysqlConnection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/DBproject",
                                "root","M.A.Toopkanlu");
                CallableStatement callableStat1;
                callableStat1=mysqlConnection.prepareCall("{call findCustomer(?,?)}");
                callableStat1.setString(1,username);
                callableStat1.setString(2,password);
                callableStat1.execute();
                ResultSet rs = callableStat1.getResultSet();
                CallableStatement callableStat2;
                if(!rs.next()){
                    callableStat2=mysqlConnection.prepareCall
                            ("{call addCustomer(?,?,?,?,?,?,?,?)}");
                    callableStat2.setString(1,username);
                    callableStat2.setString(2,password);
                    callableStat2.setString(3,city);
                    callableStat2.setString(4,province);
                    callableStat2.setString(5,street);
                    callableStat2.setString(6,phoneNum);
                    callableStat2.setString(7,postalCode);
                    callableStat2.setString(8,email);
                    callableStat2.execute();
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("New Account has been created successfully");
                    alert.showAndWait();
                    Node node=(Node) event.getSource();
                    Stage thisStage = (Stage) node.getScene().getWindow();
                    thisStage.close();
                    stage.setWidth(800.0);
                    stage.setHeight(500.0);
                    ChoosePageController pageController = new ChoosePageController(stage);
                }else {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setHeaderText("A customer with this username and password already exists!");
                    alert.showAndWait();
                    userNameSiTextField.clear();
                    passwordSiTextField.clear();
                    emailSiTextField.clear();
                    citySiTextField.clear();
                    streetSiTextField.clear();
                    provinceSiTextField.clear();
                    phoneNumSiTextField.clear();
                    postalCodeTextField.clear();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
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
                    CustomerID = rs.getString("idCustomer");
                    String customerName = rs.getString("city");
                    try {
                        stage.setWidth(800.0);
                        stage.setHeight(500.0);
                        ChoosePageController pageController = new ChoosePageController(stage);
                    }
                    catch (Exception exception){
                        System.out.println(exception.getMessage());
                    }
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
                    AdminID = rs.getString("idStaff");

                    // other attributes of admin can be here ...
                }while (rs.next());
            }
        }
    }

    public static String getAdminID() {
        return AdminID;
    }

    public static String getCustomerID() {
        return CustomerID;
    }
}
