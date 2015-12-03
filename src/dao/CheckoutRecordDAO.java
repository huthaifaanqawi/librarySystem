/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CheckoutRecord;
import model.LibraryMember;

/**
 *
 * @author 984894
 */
public class CheckoutRecordDAO {
    static final String OUTPUT_DIR = IStoragePath.OUTPUT_DIR + "checkoutRecord"; 
    
    public void addCheckoutEntry(CheckoutRecord checkoutRecord){
        
    }
    
    public CheckoutRecord getCheckoutRecord(CheckoutRecord checkoutRecord){
        List<CheckoutRecord> checkoutRecords = DataAccessUtil.readAllObject(OUTPUT_DIR);
        if(checkoutRecords.isEmpty())return checkoutRecord;
        for(CheckoutRecord cr:checkoutRecords){
            if(checkoutRecord.getLibraryMember().getId().equals(cr.getLibraryMember().getId())){
                return cr;
            }
        }
        return null;
    }
    
    public void addCheckoutRecord(CheckoutRecord checkoutRecord)throws Exception{
        CheckoutRecord cr = getCheckoutRecord(checkoutRecord);
        if(cr == null){
            DataAccessUtil.saveObject(OUTPUT_DIR, checkoutRecord.getId()+"", checkoutRecord); 
        }
    }
}
