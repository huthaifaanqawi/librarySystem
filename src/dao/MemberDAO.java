/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.LibraryMember;

/**
 *
 * @author win7
 */
public class MemberDAO {
    
    public void addMember(LibraryMember libraryMember){
        System.out.println("First Name:"+libraryMember.getFirstName());
        System.out.println("last Name:"+libraryMember.getLastName());
        System.out.println("phone Number:"+libraryMember.getPhoneNumber());
        System.out.println("State:"+libraryMember.getState());
        System.out.println("City:"+libraryMember.getCity());
        System.out.println("zip:"+libraryMember.getZip());
        System.out.println("street:"+libraryMember.getStreet());
    }
}
