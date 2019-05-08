package main.java.DenisCamacho.task_01;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ContactManager myContactManager = new ContactManager();
        boolean status = false;
        do {
            System.out.println("Menu \n 1 -> Show contact \n 2 -> Add contact \n 3 -> Search contact \n 4 -> " +
                    "Delete contact \n 5 -> Exit");
            Scanner options = new Scanner(System.in);
            System.out.println("What would you like do?");
            String option = options.nextLine();
            switch (option) {
                case "1":
                    myContactManager.showContact();
                    break;
                case "2":
                    System.out.println("Please into the data \n *name \n number \n email");
                    String data = options.nextLine();
                    while (data.equals("")) {
                        System.out.println("Into the name please");
                        data = options.nextLine();
                    }
                    Contact newContact = new Contact(data);
                    System.out.println("Into the number");
                    data = options.nextLine();
                    newContact.setPhoneNumber(data);
                    System.out.println("Into the email");
                    data = options.nextLine();
                    newContact.setEmail(data);
                    myContactManager.addContact(newContact);
                    break;
                case "3":
                    System.out.println("Into the name please");
                    data = options.nextLine();
                    Contact contact = myContactManager.searchContact(data);
                    if (contact != null)
                        System.out.println(String.format("The phone number is %s", contact.getPhoneNumber()));
                    else
                        System.out.println("Didn't find the contact");
                    break;
                case "4":
                    System.out.println("Into the contact name");
                    data = options.nextLine();
                    myContactManager.deleteContact(data);
                    break;
                case "5":
                    System.out.println("Exit the contact manager");
                    status = true;
                    break;
            }
        }
        while (!status);

    }
}
