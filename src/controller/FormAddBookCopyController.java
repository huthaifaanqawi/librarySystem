/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookCopyDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Book;
import model.BookCopy;
import util.util;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormAddBookCopyController extends SaveFormBaseController {

    @FXML
    private TextField isbnField;
    
    @FXML
    private TextField titleField;

    @FXML
    private TextField copyNumField;
    
    @FXML
    private Button addButton;
    
    BookCopyDao bookCopyDao = new BookCopyDao();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
    
    @FXML
    private void btnAddBookCopyAction(ActionEvent event)throws Exception {
        BookCopy copy = new BookCopy();
        copy.setCopynumber(copyNumField.getText());
        copy.setIsbn(isbnField.getText());
        Book book = new Book();
        book.setIsbn(isbnField.getText());
        copy.setBook(book);
        copy.setAvailable(true);
        bookCopyDao.addBookCopy(copy);     
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
        
    }

    public TextField getIsbnField() {
        return isbnField;
    }

    public TextField getTitleField() {
        return titleField;
    }


}
