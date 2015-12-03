/*
This class contains static method for validaion the values of the field
 */
package util;

public class FieldValidator {

    public static boolean isEmpty(String value) {

        return (value == null) || (value.trim().equals(""));
    }
    
    public static boolean isNumericOnly (String fieldValue){
        
        return fieldValue.matches("\\d+");  //return true if digits only      
    }
    
    //return true if the string contain only letters (i.e. A-Z or a-z)   
    public static boolean isAlphabetOnly (String fieldValue){
        
        return fieldValue.matches("[A-Za-z ]+");      
    }
    

}
