/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import model.Address;
import model.Book;
import model.BookCopy;
import model.CheckoutEntry;
import model.CheckoutRecord;
import model.LibraryMember;
import util.FolderReader;

/**
 *
 * @author win7
 */
public class MemberDAO {
    private static HashMap<String,LibraryMember> members = new HashMap<>();
    static final String OUTPUT_DIR = IStoragePath.OUTPUT_DIR + "member"; 
    public MemberDAO(){
        LibraryMember lm = new LibraryMember();
        lm.setFirstName("member");
        lm.setId("1");
        lm.setLastName("last name");
        lm.setPhoneNumber("0597267617");
        
        Address address = new Address("4th St","Fairield","IA","52557");
        
        lm.setAddress(address);
        
        CheckoutRecord cr = new CheckoutRecord();
        
        
        CheckoutEntry ce = new CheckoutEntry();
        BookCopy bookCopy = new BookCopy();
        bookCopy.setAvailable(true);
        bookCopy.setCopynumber("1");
        ce.setId("1234");
        ce.setBookCopy(bookCopy);
        ce.setCheckoutDate(new Date());
        ce.setDueDate(new Date());
        ce.setCheckoutRecord(cr);
        List<CheckoutEntry> entries = new ArrayList<CheckoutEntry>();
        entries.add(ce);
        
        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("book title");
        bookCopy.setBook(book);
        
        cr.setLibraryMember(lm);
        cr.setCheckoutEntries(entries);
        
        lm.setCheckoutRecord(cr);
        
        members.put(String.valueOf(lm.getId()), lm);
        
    }
    
    public void addMember(LibraryMember libraryMember)throws IOException{
        String lastID = FolderReader.getLastFileName(OUTPUT_DIR);
        libraryMember.setId((Integer.parseInt(lastID)+1)+"");
        DataAccessUtil.saveObject(OUTPUT_DIR, libraryMember.getId(), libraryMember);//auto generate id
    }
    
    public List<LibraryMember> getAllLibraryMembers(){
        return DataAccessUtil.readAllObject(OUTPUT_DIR);
        /*Iterator iterator = members.keySet().iterator();
        ArrayList<LibraryMember> libraryMembers = new ArrayList<>();
        while(iterator.hasNext()){
            String key = (String)iterator.next();
            LibraryMember member = (LibraryMember)members.get(key);
            libraryMembers.add(member);
        }
        return libraryMembers;*/
    }
    
    public LibraryMember getLibraryMember(int id){
        return null;
    }
}
