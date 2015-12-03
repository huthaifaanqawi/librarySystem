/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.SaveFormBaseController;
import dao.MemberDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.LibraryMember;

/**
 *
 * @author win7
 */
public class FormAddMemberController extends SaveFormBaseController {

    @FXML
    private ComboBox state;
    
    @FXML
    private ComboBox city;
    
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;
    
    @FXML
    private TextField phoneNumber;
    
    @FXML
    private Button add;
    
    @FXML
    private TextField street;
    
    @FXML
    private TextField zip;

    private MemberDAO memberDAO;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        state.getItems().clear();

        state.getItems().addAll(
                "Palestine",
                "Germany",
                "British",
                "china",
                "japan");
        
        city.getItems().clear();

        city.getItems().addAll(
                "Ramallah",
                "Nablus",
                "Jenin",
                "Haifa",
                "Jaffa");

        add.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                addMember();
            }  
        });
        
        memberDAO = new MemberDAO();
    }
    
    public void addMember(){
        
    }

}
