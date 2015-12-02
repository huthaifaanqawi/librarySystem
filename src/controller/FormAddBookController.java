/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.Book;

/**
 * FXML Controller class
 *
 * @author Huthayfa
 */
public class FormAddBookController extends FormBaseController {

    @FXML
    private TextField txtISBN;//13 digits number e.g. 978-3-16-148410-5
    
    @FXML
    private TextField txtTitle;
    
    //TODO: Hanle Authors
    
    @FXML
    private ComboBox<Integer> cmbCheckoutLength;   
    
    @FXML
    private Button btnSave;
    
    private List<String> invalidFields;//to add the invlaid fields
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        cmbCheckoutLength.getItems().addAll(7, 21); //possible values of the comboBox 
        invalidFields = new ArrayList<>();
        
        //Validations
        txtISBN.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) { //when focus lost
            String textValue = txtISBN.getText();
            if(textValue.equals("") || !textValue.matches("\\d*") || textValue.length() != 13){
                //when it not matches the pattern (1.0 - 6.0)
                //set the textField empty
                txtISBN.setText("Enter 13 digit number");
                invalidFields.add("ISBN");
            }
            else
                invalidFields.remove("ISBN");
        }

    });
        
        
    } 
    
    @FXML
    private void btnSaveAction(ActionEvent event) {
        System.out.println("Implement Save");

        if (!invalidFields.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Following fields are invalid: ");
            alert.setContentText(invalidFields.toString());
            alert.showAndWait();
            return;
        }
        
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
