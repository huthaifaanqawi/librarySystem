/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 984894
 */
public class CheckoutRecord implements Serializable{
    
    private int id;    
    private LibraryMember libraryMember;
    private List<CheckoutEntry> checkoutEntries;//ChecoutRecord consists of many of entries 
    private List<Fine> fines;   

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
        this.checkoutEntries = checkoutEntries;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
