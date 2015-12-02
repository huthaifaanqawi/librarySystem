/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CheckoutRecordDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.*;
import model.CheckoutRecord;
/**
 *
 * @author 984894
 */
public class FormCheckoutRecordDetailController extends FormBaseController {
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField isbn;
    
    @FXML
    private TextField title;
    
    @FXML
    private TextField author;
    
    @FXML
    private Button editBtn;
    
    private CheckoutRecordDAO checkoutRecordDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkoutRecordDAO = new CheckoutRecordDAO();

    }
    
    public void editCheckoutRecord(){
        CheckoutRecord checkoutRecord = new CheckoutRecord();
        checkoutRecord.setId(id.getText());
        checkoutRecord.setFirstName(firstName.getText());
        checkoutRecord.setLastName(lastName.getText());
        checkoutRecord.setISBN(isbn.getText());
        checkoutRecord.setTitle(title.getText());
        checkoutRecord.setAuthors(author.getText());
        checkoutRecordDAO.editCheckoutRecord(checkoutRecord);
    }
    
}
