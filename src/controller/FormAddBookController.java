/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.Book;
import util.FieldValidator;

/**
 * FXML Controller class
 *
 * @author Huthayfa
 */
public class FormAddBookController extends SaveFormBaseController {

    @FXML
    private TextField txtISBN;//13 digits number e.g. 978-3-16-148410-5
    
    @FXML
    private TextField txtTitle;
    
    //TODO: Hanle Authors
    
    @FXML
    private ComboBox<Integer> cmbCheckoutLength;   
    
    @FXML
    private Button btnSave;
    
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbCheckoutLength.getItems().addAll(7, 21); //possible values of the comboBox 
        

        //Validations
        txtISBN.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
                if (!newValue) { //when focus lost
                    String textValue = txtISBN.getText();
                    if (FieldValidator.isEmpty(textValue) || !FieldValidator.isNumericOnly(textValue) || textValue.length() != 13) {
                        //when it not valid, set the textField to right message and add the field to invalidFields
                        txtISBN.setText(txtISBN.getText() + " Enter 13 digit number");                        
                        txtISBN.setStyle(INVALID_STYLE);
                        if (!invalidFields.contains("ISBN"))
                            invalidFields.add("ISBN");
                    } else {//if it is valid, remove it from the list (either it added before or not) if not added before, nothing removed
                        invalidFields.remove("ISBN");
                        //txtISBN.setStyle("-fx-background-color: white;");
                        txtISBN.setStyle(VALID_STYLE);
                    }
                }
            }
        });

        
    } 
    
    @FXML
    private void btnSaveAction(ActionEvent event) {
        System.out.println("Implement Save");

        if ( !validate() ) // if not valid don't continu, just return to the form
            return;        
        
        //if The data is valid
        Book book = new Book();
        book.setIsbn(txtISBN.getText());
        book.setTitle(txtTitle.getText());
        //bo
        
        BookDao bookDao = new BookDao();
        Boolean saveResult = bookDao.addBook(book);
        if (!saveResult) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Saving Book Failed");           
            alert.showAndWait();
            return;
        }
    }
    
    
    
    
           

}
