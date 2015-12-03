/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import dao.CheckoutEntryDAO;
import dao.CheckoutRecordDAO;
import dao.MemberDAO;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Book;
import model.BookCopy;
import model.CheckoutEntry;
import model.CheckoutRecord;
import model.LibraryMember;
import util.util;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormCheckoutController extends SaveFormBaseController {

    @FXML
    private Button exportButton;

    @FXML
    private ChoiceBox boxBook;

    @FXML
    private ComboBox member;
    
    @FXML
    private DatePicker dueDate;

    MemberDAO memberDAO = new MemberDAO();

    BookDao bookDAO = new BookDao();

    CheckoutRecordDAO checkoutRecordDAO = new CheckoutRecordDAO();

    CheckoutEntryDAO checkoutEntryDAO = new CheckoutEntryDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<LibraryMember> members = memberDAO.getAllLibraryMembers();
        List<String> member_ids = new ArrayList<>();
        for (LibraryMember member : members) {
            member_ids.add(member.getId());
        }
        member.setItems(FXCollections.observableArrayList(member_ids));

        List<Book> books = bookDAO.getAllBooks();
        List<String> book_titles = new ArrayList<>();
        for (Book book : books) {
            book_titles.add(book.getTitle());
        }
        boxBook.setItems(FXCollections.observableArrayList(book_titles));
    }

    @FXML
    public void handleSubmitAction() {
        CheckoutRecord checkoutRecord = new CheckoutRecord();
        LibraryMember libraryMember = new LibraryMember();
        libraryMember.setId(member.getValue().toString());
        CheckoutEntry checkoutEntry = new CheckoutEntry();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        checkoutEntry.setCheckoutDate(formatter.format(dueDate.getValue()));
        checkoutEntry.setDueDate(formatter.format(dueDate.getValue()));
        checkoutEntry.setCheckoutRecord(checkoutRecord);
        checkoutRecord.setLibraryMember(libraryMember);
        BookCopy bookCopy = new BookCopy();
        bookCopy.setCopynumber("123456");
        checkoutEntry.setBookCopy(bookCopy);
        try {
            checkoutRecordDAO.addCheckoutRecord(checkoutRecord);
            checkoutEntryDAO.addCheckoutEntry(checkoutEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleExportButtonAction(ActionEvent event) {

        Stage stage = new Stage();

        util.log("Exporting data to file .csv...");

        String defaultFileName = "LibrarySystemExport.csv";

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.setInitialFileName(defaultFileName);
        File savedFile = fileChooser.showSaveDialog(stage);
        if (savedFile != null) {
            try {
                saveFileRoutine(savedFile);
            } catch (Exception e) {
                e.printStackTrace();
                //actionStatus.setText("An ERROR occurred while saving the file!");
                return;
            }
            //actionStatus.setText("File saved: " + savedFile.toString());
        } else {
            //actionStatus.setText("File save cancelled.");
        }

        util.log("Export complete");
    }

    private void saveFileRoutine(File file)
            throws Exception {

        try {
            // Creates a new file and writes the txtArea contents into it
            String txt = "Text content";

            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(txt);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
