/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanager;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author veymarmc
 */
public class MenuContact {
    private Scanner reader = new Scanner(System.in);
//    private Contact contact;
    private ContactList contactList;

    public MenuContact() {
        contactList = new ContactList();
        start();
    }
    
    public void start() {
        int optionMenu = 0;
        while(optionMenu != 4){
            this.showMainMenu();
            optionMenu = this.readOptionMenu();
            
            switch(optionMenu) {
                case 1: this.addContactInterface();
                    break;
                case 2: this.showContactInterface();
                    break;
                case 3: this.searchContactInterface();
            }
        }
    }
    
    public void showMainMenu() {
        System.out.println("----- Menu Contact -----");
        System.out.println("1.- Add Contact");
        System.out.println("2.- Show Contacts");
        System.out.println("3.- Search Contacts");
        System.out.println("4.- Exit");
        System.out.println("Select an option... (type a number of the list)");
    }

    public int readOptionMenu() {
        boolean isInvalidOption = true;
        int optionMenu = 0;
        
        while(isInvalidOption) {
            try {
                optionMenu = this.reader.nextInt();
                if (optionMenu < 1 || optionMenu > 4) {
                    throw new Exception();
                }
                isInvalidOption = false;
            } catch (Exception e) {
                System.out.println("You should put an Integer, and a valid option");
            }
        }
        
        return optionMenu;
    }
    
    public String readString(boolean required) {
        boolean invalidAnswer = true;
        String answer = "";
        while(invalidAnswer) {
            answer = this.reader.nextLine();
            if(answer.equals("") && required) {
                System.out.println("This should not be empty");
            } else {
                invalidAnswer = false;
            }
        }
        return answer;
    }
    
    public void addContactInterface() {
        String name, phone, email;
        System.out.println("----- Add Contact -----");
        System.out.println("Add the name of the contact");
        name = this.readString(true);
        System.out.println("Add the phone of the contact");
        phone = this.readString(false);
        System.out.println("Add the email");
        email = this.readString(false);
        
        Contact contact = new Contact(name, phone, email);
        contactList.addContact(contact);
        System.out.println("New Contact Added!!");
    }
    
    public void showContactInterface() {
        System.out.println("----- Contacts List -----");
        Vector contacts = contactList.getContacts();
        
        this.showContacts(contacts);
    }
    
    private void showContacts(Vector contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            String contactToShow = this.getContactToShow((Contact)contacts.get(i));
            System.out.println((i+1) + ".- " + contactToShow);
        }
    }
    
    private String getContactToShow(Contact contact) {
        return contact.getName() + ", "
                    + contact.getPhone() + ", " + contact.getEmail();
    }
    
    public void searchContactInterface() {
        System.out.println("----- Search Contact -----");
        System.out.println("Input the keyword to search...");
        String searchWord = this.readString(true);
        
        Vector foundContacts = contactList.searchContacts(searchWord);
        this.showContacts(foundContacts);
    }
}
