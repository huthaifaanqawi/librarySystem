/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.SaveFormBaseController;
import dao.MemberDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Address;
import model.LibraryMember;
import util.Message;

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
        
        memberDAO = new MemberDAO();
    }
    
    @FXML
    private void addMember(ActionEvent event) {
        LibraryMember libraryMember = new LibraryMember();
        libraryMember.setFirstName(firstName.getText());
        libraryMember.setLastName(lastName.getText());
        libraryMember.setPhoneNumber(phoneNumber.getText());
        libraryMember.setAddress(new Address(street.getText(),city.getValue().toString(),state.getValue().toString(),zip.getText()));
        try {
            memberDAO.addMember(libraryMember);
            Message.showSuccessMessage("Add Member", "Saving Member Sucess", "");            
        } catch (IOException ex) {
            Message.showErrorMessage("Add Member", "Saving Member Failed. Exception message: ",  ex.getMessage());          
            
        }
        
    }

}
