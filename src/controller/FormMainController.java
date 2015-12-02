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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.util;
import Main.Main;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormMainController implements Initializable {

    @FXML
    public Button checkoutButton;

    @FXML
    public Button checkoutRecordButton;

    @FXML
    public Button addMemberButton;

    @FXML
    public Button editMemberButton;

    @FXML
    public Button addBookButton;

    @FXML
    public Button addBookCopyButton;

    @FXML
    public Button logoffButton;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void handleLogoffButtonAction(ActionEvent event) {

        Main main = new Main();
        
        Stage mainStage = new Stage();
        
        Stage stage = (Stage) logoffButton.getScene().getWindow();
        
        util.log("Logging off application");
        
        main.start(mainStage);
        
        stage.close();

        
    }
    
    private void launchForm(String formURL) {
         
         Stage stage = new Stage();
        
         try {

            util.log("Starting " + formURL + "...");
            util.log("Setting FXML file");
            Parent root = FXMLLoader.load(getClass().getResource(formURL));
            
            root.setStyle("-fx-background-color:  #8EC6E7");

            
            util.log("Loading scene");
            Scene scene = new Scene(root);

            util.log("Setting scene stage");
            stage.setScene(scene);

            stage.setResizable(false);

            util.log("Showing " + formURL +  " form");
            stage.show();
            
        } catch(Exception e) {
            util.log(e.toString());
            e.printStackTrace();
	}      
        
    }
    
    @FXML
    public void handleCheckoutButtonAction(ActionEvent event) {
        launchForm("/view/FormCheckout.fxml");
    }

    public void handleCheckoutRecordButtonAction(ActionEvent event) {
        launchForm("/view/FormCheckoutRecord.fxml");
    }
    
    public void handleAddMemberButtonAction(ActionEvent event) {
        launchForm("/view/FormAddMember.fxml");
    }
    
    public void handleEditMemberButtonAction(ActionEvent event) {
        launchForm("/view/FormAddMember.fxml");
    }

    public void handleAddBookButtonAction(ActionEvent event) {
        launchForm("/view/FormAddBook.fxml");
    }
    
    public void handleAddBookCopyButtonAction(ActionEvent event) {
        launchForm("/view/FormAddBook.fxml");
    }
    
}
