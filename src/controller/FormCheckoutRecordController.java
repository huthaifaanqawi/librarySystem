/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.util;
import model.CheckoutRecord;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormCheckoutRecordController extends FormBaseController {
    @FXML
    private ChoiceBox member;
    
    @FXML
    private ChoiceBox book;
    
    @FXML
    private TableView tableView;
    
    @FXML
    private Button export;
    
    @FXML
    private Button ok;
    
    private CheckoutRecord checkoutRecord = new CheckoutRecord();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadTableView();

        tableView.getSelectionModel().selectedItemProperty()
                        .addListener((observable, oldValue, newValue) -> handleTableViewDoubleClickAction());
        
    }    
    
    
    public void loadTableView() {
        List checkoutRecords = new ArrayList<String>();
        CheckoutRecord cr = new CheckoutRecord();
        /*cr.setFirstName("Mauro");
        cr.setDate("10-08-2015");
        cr.setISBN("123");
        checkoutRecords.add(cr);
        
        CheckoutRecord cr2 = new CheckoutRecord();
        cr.setFirstName("Mauro");
        cr.setDate("10-01-2015");
        cr.setISBN("345");
        checkoutRecords.add(cr);

        tableView.getItems().addAll(FXCollections.observableList(checkoutRecords));
*/
    }
    
    
    public void handleTableViewDoubleClickAction() {

        tableView.setOnMousePressed((MouseEvent event) -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                
                int rowIndex = tableView.getSelectionModel().getSelectedIndex();
                ObservableList rowList = (ObservableList) tableView.getItems().get(rowIndex);   
                
                
                //Retrieving CheckoutID
                String checkoutKey = rowList.get(0).toString();
                
                
                        
                Stage stage = new Stage();

                util.log("Loading detailed record form...");

                try {
                    String formURL = "FormCheckoutRecordDetails.fxml";

                    Parent root = FXMLLoader.load(getClass().getResource("/view/" + formURL));

                    root.setStyle("-fx-background-color:  #8EC6E7");

                    util.log("Loading " + formURL);
                    Scene scene = new Scene(root);

                    util.log("Setting scene stage");
                    stage.setScene(scene);

                    stage.setResizable(false);
                    stage.setAlwaysOnTop(true);

                    util.log("Showing " + formURL);
                    stage.show();

                } catch(Exception e) {
                    e.printStackTrace();
                    }
            }
        });

    }
   
    
}
