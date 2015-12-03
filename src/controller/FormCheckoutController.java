/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.util;

/**
 * FXML Controller class
 *
 * @author mauro
 */
public class FormCheckoutController extends SaveFormBaseController {

    @FXML
    private Button exportButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            }
            catch(Exception e) {
                e.printStackTrace();
                //actionStatus.setText("An ERROR occurred while saving the file!");
                return;
            }
            //actionStatus.setText("File saved: " + savedFile.toString());
        }
        else {
            //actionStatus.setText("File save cancelled.");
        }

        
        util.log("Export complete");
    }
    
    private void saveFileRoutine(File file)
			throws Exception{
		
        try {
            // Creates a new file and writes the txtArea contents into it
            String txt = "Text content";

            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(txt);
            writer.close();
        } catch(Exception e) {
                            e.printStackTrace();                            
            }
	}
    
}
