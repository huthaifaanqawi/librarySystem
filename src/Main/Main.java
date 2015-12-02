/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.*;
/**
 *
 * @author mauro
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            setUserAgentStylesheet(STYLESHEET_MODENA);

            
            util.log("Starting application...");
            util.log("Setting FXML file for Login screen");
            Parent root = FXMLLoader.load(getClass().getResource("/view/FormLogin.fxml"));
            
            root.setStyle("-fx-background-color:  #8EC6E7");

            util.log("Loading FXML scene");
            Scene scene = new Scene(root);

            util.log("Setting scene stage");
            primaryStage.setScene(scene);

            primaryStage.setResizable(false);

            util.log("Showing Login screen form");
            primaryStage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
        launch(args);
    }
        
}
