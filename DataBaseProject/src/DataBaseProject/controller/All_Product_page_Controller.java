package DataBaseProject.controller;

import DataBaseProject.Model.ConnectData;
import DataBaseProject.view.QueryPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class All_Product_page_Controller {
        QueryPage queryPage;
        ConnectData connectData;
        @FXML
        private Label lbl_res;

        @FXML
        private TableView<?> all_Product_tableview;

        @FXML
        private TableColumn<?, ?> col_id_all_product;

        @FXML
        private TableColumn<?, ?> col_name_all_product;

        @FXML
        private TableColumn<?, ?> col_typeName_all_product;

        @FXML
        private TableColumn<?, ?> col_price_all_product;

        @FXML
        private TableColumn<?, ?> col_discount_all_product;

        @FXML
        private Button btn_change_all_product;

        @FXML
        private Button btn_add_all_product;

        @FXML
        private Button btn_remove_all_product;

        @FXML
        private TextField txt_id_all_product;

        @FXML
        private TextField txt_name_all_product;

        @FXML
        private TextField txt_typeName_all_product;

        @FXML
        private TextField txt_price_all_product;

        @FXML
        private TextField txt_discount_all_product;

        @FXML
        void change_Product_all(ActionEvent event) {

        }

        @FXML
        void delet_Product_all(ActionEvent event) {

        }

        @FXML
        void insert_Product_all(ActionEvent event) {
            String Pid= txt_id_all_product.getText();
            String Oid=txt_name_all_product.getText();
            String discount=txt_discount_all_product.getText();
            String price=txt_price_all_product.getText();
            String tName=txt_typeName_all_product.getText();
            String q= "INSERT INTO" +
                    " dbproject.product (`idProduct`, `idOrders`, `discount`,  `price`, `type_name`) VALUES ("+
                    Pid+" , "+Oid+" , "+discount+" , "+price+" , "+tName+')';
            connectData.insertData(q,lbl_res);

        }

    }

