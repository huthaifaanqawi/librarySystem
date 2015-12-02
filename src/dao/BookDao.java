/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Book;

/**
 *
 * @author 984959
 */
public class BookDao {
    
    static final String OUTPUT_DIR = IStoragePath.OUTPUT_DIR + "book"; 
    
    
    //TODO: check if we want to return result or not
    public boolean addBook(Book book){       
        DataAccessUtil.saveObject(OUTPUT_DIR, book.getIsbn(), book);       
        return false;
    }
    
    //get all books 
    public List<Book> getAllBooks(){
        return DataAccessUtil.readAllObject(OUTPUT_DIR);
    }
    
    //if addBook implemented by save based on Isbn -> then method is ok 
    public Book getBookByIsbn(String isbn){
        return DataAccessUtil.readGenericObject(OUTPUT_DIR, isbn);
    }
    
}
