/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import dao.SystemUserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.launch;
import static javafx.application.Application.setUserAgentStylesheet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.SystemUser;
import util.*;
/**
 *
 * @author mauro
 */
public class Main extends Application {
   

    
    @Override
    public void start(Stage primaryStage) {
        
        
       SystemUser admin = new SystemUser();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(SystemUser.AuthorizationLevel.ADMINISTRATOR);
        
        SystemUserDAO adminDAO = new SystemUserDAO();
        
        SystemUser librarian = new SystemUser();
        librarian.setUsername("lib");
        librarian.setPassword("lib");
        librarian.setRole(SystemUser.AuthorizationLevel.LIBRARIAN);
        
        SystemUserDAO librarianDAO = new SystemUserDAO();
        
        SystemUser rootUser = new SystemUser();
        rootUser.setUsername("root");
        rootUser.setPassword("root");
        rootUser.setRole(SystemUser.AuthorizationLevel.BOTH);
        
        SystemUserDAO rootDAO = new SystemUserDAO();
        
        
        try {
            adminDAO.addUser(admin);
            librarianDAO.addUser(librarian);
            rootDAO.addUser(rootUser);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        
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

            //primaryStage.getIcons().add(new Image("Main/books.png"));
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
