/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CheckoutRecord;
import model.LibraryMember;
import util.FolderReader;

/**
 *
 * @author 984894
 */
public class CheckoutRecordDAO {
    static final String OUTPUT_DIR = IStoragePath.OUTPUT_DIR + "checkoutRecord"; 
    
    public void addCheckoutEntry(CheckoutRecord checkoutRecord){
        
    }
    
    public CheckoutRecord getCheckoutRecordByLibraryMember(CheckoutRecord checkoutRecord){
        List<CheckoutRecord> checkoutRecords = DataAccessUtil.readAllObject(OUTPUT_DIR);
        for(CheckoutRecord cr:checkoutRecords){
            if(checkoutRecord.getLibraryMember().getId().equals(cr.getLibraryMember().getId())){
                return cr;
            }
        }
        return null;
    }
    
    public void addCheckoutRecord(CheckoutRecord checkoutRecord)throws Exception{
        String lastID = FolderReader.getLastFileName(OUTPUT_DIR);
        checkoutRecord.setId((Integer.parseInt(lastID)+1)+"");
        CheckoutRecord cr = getCheckoutRecordByLibraryMember(checkoutRecord);
        if(cr == null){
            DataAccessUtil.saveObject(OUTPUT_DIR, checkoutRecord.getId(), checkoutRecord); 
        }
    }
}
