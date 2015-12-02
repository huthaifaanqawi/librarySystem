/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.util;

/**
 *
 * @author mauro
 */
public class FormBaseController implements Initializable {
    @FXML
    Button cancelButton;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    public void handleCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        util.log("Cancelling action/form");

        stage.close();
    }
    
}
