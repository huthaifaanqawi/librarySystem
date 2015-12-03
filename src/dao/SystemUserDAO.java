/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.SystemUser;

/**
 *
 * @author mauro
 */
public class SystemUserDAO {

    static final String OUTPUT_DIR = IStoragePath.OUTPUT_DIR + "user"; 
    private SystemUser user;

    public SystemUserDAO() {};
    
    public SystemUserDAO(String username) {
        user = getUser(username);
    }
    
    public boolean isNull() {
        if (user == null)
            return true;
        
        return false;
    }
    
    public SystemUser getUser() {
        return user;
    }
    

    public void setUser(SystemUser user) {
        this.user = user;
    }
    
    public void addUser (SystemUser user){     
        
        //DataAccessUtil.saveObject(OUTPUT_DIR, user.getUsername(), user); 
        
    }
        //if addBook implemented by save based on Isbn -> then method is ok 
    public SystemUser getUser(String username){
        return DataAccessUtil.readGenericObject(OUTPUT_DIR, username);
    }
    
}
