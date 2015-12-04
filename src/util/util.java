/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import Main.Main;
import dao.IStoragePath;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.FileChooser;

/**
 *
 * @author mauro
 */
public class util {
    
    
    private static boolean writeToConsole = true;
    
    private static boolean writeToFile = false;

    public static boolean isWriteToFile() {
        return writeToFile;
    }

    public static void setWriteToFile(boolean _writeToFile) {
        writeToFile = _writeToFile;
    }

    public static boolean isWriteToConsole() {
        return writeToConsole;
    }

    public static void setWriteToConsole(boolean _writeToConsole) {
        writeToConsole = _writeToConsole;
    }
    
    public static void log(String msg) {
        
       if (isWriteToConsole()) {
           //System.out.println(callerClassName + ": "+ msg);
           System.out.println("System Library: " + msg);
       } 
       
       if (isWriteToFile()) {
           //Must write in a log file...
           //System.out.println(callerClassName + ": "+ msg);
           System.out.println(msg);
       }
        
    }

    public static void log(Object o, String msg) {
         String callerClassName = o.getClass().getName();
        
        
       if (isWriteToConsole()) {
           System.out.println("System Library("+ callerClassName + "): " + msg);
           System.out.println("System Library: " + msg);
       } 
       
       if (isWriteToFile()) {
           //Must write in a log file...
           //System.out.println(callerClassName + ": "+ msg);
           System.out.println(msg);
           //saveFileRoutine(file, msg);
       }
        
    }
    
    public static void setLogFile() {
        
        File logFile;
        
    }
    
    private static void saveFileRoutine(File file, String txt)
			throws Exception{
		
        try {

            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(txt);
            writer.close();
        } catch(Exception e) {
                            e.printStackTrace();                            
            }
	}
    
    public static void createInitialStorageDirs() {
        List<File> folderList = new ArrayList<File>();
        boolean success;
        
        
        folderList.add(new File(IStoragePath.OUTPUT_DIR + "bookCopy"));
        folderList.add(new File(IStoragePath.OUTPUT_DIR + "book"));
        folderList.add(new File(IStoragePath.OUTPUT_DIR + "checkoutEntry"));
        folderList.add(new File(IStoragePath.OUTPUT_DIR + "checkoutRecord"));
        folderList.add(new File(IStoragePath.OUTPUT_DIR + "member"));
        folderList.add(new File(IStoragePath.OUTPUT_DIR + "user"));
        
        
        for (File folder : folderList ) {
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
        }
        
    }
    
}
