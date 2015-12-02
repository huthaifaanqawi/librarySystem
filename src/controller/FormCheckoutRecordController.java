/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import util.util;

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tableView.getSelectionModel().selectedItemProperty()
                        .addListener((observable, oldValue, newValue) -> handleTableViewClickAction());
    }    
    
    
    
    public void handleTableViewClickAction() {

        Stage stage = new Stage();
        
        util.log("Loading detailed record form...");
        
        //if(mouseEvent.getClickCount() == 2) 
        { 
            try {
                String formURL = "FormCheckoutRecordDetails.fxml";

                Parent root = FXMLLoader.load(getClass().getResource("/view/" + formURL));

                root.setStyle("-fx-background-color:  #8EC6E7");

                util.log("Loading " + formURL);
                Scene scene = new Scene(root);

                util.log("Setting scene stage");
                stage.setScene(scene);

                stage.setResizable(false);

                util.log("Showing " + formURL);
                stage.show();

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
   
    
}
