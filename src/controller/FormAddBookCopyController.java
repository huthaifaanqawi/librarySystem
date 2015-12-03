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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.util;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormAddBookCopyController extends SaveFormBaseController {

    @FXML
    private TextField isbnField;
    
    @FXML
    private TextField titleField;

    @FXML
    private Button addButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void btnAddBookCopyAction(ActionEvent event) {
        util.log("Adding book copy...");
        
        Stage stage = (Stage) addButton.getScene().getWindow();
        
        //Implements save copy method here
        
        stage.close();
        
    }

}
