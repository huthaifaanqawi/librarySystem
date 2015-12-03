/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.CheckoutEntry;

/**
 *
 * @author 984894
 */
public class CheckoutEntryDAO {
    static final String OUTPUT_DIR = IStoragePath.OUTPUT_DIR + "checkoutEntry"; 
    
    public void addCheckoutEntry(CheckoutEntry checkoutEntry)throws Exception{
        DataAccessUtil.saveObject(OUTPUT_DIR, checkoutEntry.getId(), checkoutEntry); 
    }
}
