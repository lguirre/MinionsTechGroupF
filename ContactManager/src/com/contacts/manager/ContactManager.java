package com.contacts.manager;

import com.contacts.model.Contact;

import java.util.List;
import java.util.ArrayList;

public class ContactManager {

    private static final ContactManager myClass = new ContactManager();
    private static List<Contact> contacts = new ArrayList<Contact>();

    private ContactManager() {

    }

    public static ContactManager getInstance() {
        return myClass;
    }

    public void addContacts(Contact value) {
        contacts.add(value);
        System.out.println("    [ CONTACT SAVED ]");
        System.out.println("    ");
    }

    public void showContacts(){
        if(contacts.size() == 0){
            System.out.println("    * [ NO CONTACTS SAVED ]");
            System.out.println("    ");

        }else {
            for (Contact i : contacts) {
                System.out.println("    * Name : " + i.getName());
                System.out.println("    * Email : " + i.getEmail());
                System.out.println("    * PhoneNumber : " + String.valueOf(i.getPhoneNumber()));
                System.out.println("    ");
            }
        }
    }

    public void deleteContacts(String value) {
        boolean res = false;
        List<Contact> aux = new ArrayList<Contact>();
        for(Contact i : contacts){
            if(!i.getName().equals(value)){
                aux.add(i);
                res = true;
            }
        }
        System.out.println("    ");
        if(res){
            System.out.println("[ CONTACT DELETED ]");
        }else{
            System.out.println("[ CONTACT NOT FOUND OR NOT EXISTS ]");
        }
        System.out.println("    ");
        contacts = aux;
    }

    public void searchContacts(String value) {
        boolean res = false;
        for(Contact i : contacts){
            if(i.getName().equals(value)){
                res = true;
                System.out.println("    * Name : " + i.getName());
                System.out.println("    * Email : " + i.getEmail());
                System.out.println("    * PhoneNumber : " + String.valueOf(i.getPhoneNumber()));
                System.out.println("    ");
            }
        }
        if(!res){
            System.out.println("    * [ COULD NOT FIND CONTACT ] ");
            System.out.println("    ");
        }
    }
}
