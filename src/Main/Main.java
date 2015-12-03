/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.*;
/**
 *
 * @author mauro
 */
public class Main extends Application {
   
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static Date _today = Calendar.getInstance().getTime();        
    private static String today = df.format(_today);
    
    //private String = "LibrarySystem_" + today + ".log";
    private String logName = "LibrarySystem_" + today + ".log";
    
    public String getLogName() {
        return logName;
    }
    
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

            primaryStage.getIcons().add(new Image("Main/books.png"));
            primaryStage.setTitle("Library System 1.0");
            
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
