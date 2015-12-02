/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.Main;
import util.util;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;

    @FXML
    public Button cancelButton;

    @FXML
    private Button signInButton;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        util.log("Closing application");

        stage.close();
    }

    @FXML
    public void handleSignInButtonAction(ActionEvent event) {

        Stage mainStage = new Stage();
        
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        
        util.log("Signing in application");
        
        //check user and password
        

        //Executes if user/password set is valid
        try {
            
            util.log(this.getClass().getName(),"Starting Main Frame...");
            util.log("Setting FXML file");
            Parent root = FXMLLoader.load(getClass().getResource("/view/FormMain.fxml"));
            util.log("Loading FXML scene for Main Frame");

            util.log("Setting scene");
            Scene scene = new Scene(root);
            
            mainStage.setScene(scene);
            mainStage.setResizable(false);

            //closing previous screen (login screen)
            util.log("Closing previous form");
            stage.close();
            mainStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
    
        }
        
        
    }
    
    @FXML
    public void handleLogoffButtonAction(ActionEvent event) {

        Stage mainStage = new Stage();
        
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        
        util.log("Signing in application");
        
        //check user and password
        

        //Executes if user/password set is valid
        try {
            
            util.log(this.getClass().getName(),"Starting Main Frame...");
            util.log("Setting FXML file");
            Parent root = FXMLLoader.load(getClass().getResource("/view/FormMain.fxml"));
            util.log("Loading FXML scene for Main Frame");

            util.log("Setting scene");
            Scene scene = new Scene(root);
            
            mainStage.setScene(scene);
            mainStage.setResizable(false);

            //closing previous screen (login screen)
            util.log("Closing previous form");
            stage.close();
            mainStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
    
        }
        
        
    }
    
}
