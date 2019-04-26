package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    Scanner sn;
    boolean out;
    ContactManager contacts;
    int option;

    public Console() {
        this.sn = new Scanner(System.in);
        this.out = false;
        this.contacts = new ContactManager();
    }

    public void ContactMenu() {
        while (!out) {

            System.out.println("1. adds a Contact 1");
            System.out.println("2. Show a Contact 2");
            System.out.println("3. Search Contact 3");
            System.out.println("4. exit");

            try {

                System.out.println("Write one of the options");
                option = sn.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("You have selected the option 1");
                        addContacts();
                        break;
                    case 2:
                        System.out.println("You have selected the option 2");
                        listShowAllContact();
                        break;
                    case 3:
                        System.out.println("You have selected the option 3");
                        searchContact();
                        break;
                    case 4:
                        out = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must insert a number");
                sn.next();
            }
        }
    }

    /**
     * Method for add contacts
     */
    public void addContacts() {
        System.out.println("Enter the Name");
        String name = sn.next();
        System.out.println("Enter the phone");
        String phone = sn.next();
        System.out.println("Enter the email");
        String email = sn.next();
        contacts.addContact(name, phone, email);

    }

    /**
     * Method for list Show Contacts
     */
    public void listShowAllContact() {
        contacts.showContacts();
    }

    /**
     * Method for search contacts
     */
    public void searchContact() {
        System.out.println("Enter the Name to search");
        String name = sn.next();
        contacts.searchContact(name);
    }


}
