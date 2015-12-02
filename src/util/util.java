/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
       }
        
    }
    
}
