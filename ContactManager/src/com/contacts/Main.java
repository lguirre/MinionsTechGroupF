package com.contacts;

import com.contacts.manager.ContactManager;
import com.contacts.model.Contact;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContactManager manager = ContactManager.getInstance();
        Scanner scanner;
        int control = 0;
        while(control != 5){
            scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("================= [ CONTANT MANAGER ] =================");
            System.out.println("");
            System.out.println("1.- Add Contact");
            System.out.println("2.- Show Contacts");
            System.out.println("3.- Search Contact");
            System.out.println("4.- Remove Contact");
            System.out.println("5.- Quit");
            System.out.println("");
            System.out.println("[ SELECT AN OPTION ]");
            control = readNumber(scanner);
            switch (control){
                case 1:
                    System.out.println("");
                    System.out.println("- Enter a name:");
                    String name = readString(scanner);
                    System.out.println("- Enter an email");
                    String email = readString(scanner);
                    System.out.println("- Enter a phone number:");
                    long number = readNumber(scanner);
                    manager.addContacts(new Contact(name, email, number));
                    readKey();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("[ SHOWING ALL SAVED CONTACTS ]");
                    System.out.println("");
                    manager.showContacts();
                    readKey();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("- Enter a name:");
                    String name2 = readString(scanner);
                    manager.searchContacts(name2);
                    readKey();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("- Enter a name:");
                    String name3 = readString(scanner);
                    manager.deleteContacts(name3);
                    readKey();
                    break;
                case 5:
                    System.out.println("[ QUIT... ]");
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }
    }

    private static int readNumber(Scanner input){
        try{
            return input.nextInt();
        }catch(Exception ex){
            return 0;
        }
    }

    private static String readString(Scanner input){
        try{
            return input.next();
        }catch(Exception ex){
            return "";
        }
    }


    private static void readKey(){

        try {
            System.out.println("");
            System.out.println("[ PRESS ENTER TO CONTINUE. ]");
            System.in.read();
        } catch (IOException e) {

        }
    }
}
