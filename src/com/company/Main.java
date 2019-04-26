package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Menu menu1= new Menu();

        System.out.println("Options of the menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Show Contact");
        System.out.println("3. Search Contact");
        System.out.println("4. Exit");
        String option = in.nextLine();
        System.out.println("Type the option you want(select any number of the options above)");

        int result = Integer.parseInt(option);
        switch (result) {
            case 1:
                option.equals("1");

                System.out.println(" Enter new contact");
                System.out.println("Add name:");
                String nameUser = in.nextLine();

                System.out.println("Add telephone:");
                String telephoneUser = in.nextLine();

                System.out.println("Add email:");
                String emailUser = in.nextLine();

                Contact newUser = new Contact(nameUser,telephoneUser,emailUser);
                menu1.AddContact(newUser);
                System.out.println("New user added");

                break;
            case 2:
                option.equals("2");
                String option1 = in.nextLine();
                System.out.println(" Show the contacts added: Y/N");
                if (option1.equals("Y")) {
                    menu1.ShowContact();
                } else {
                    System.out.println("Select other option");
                }
                break;
            case 3:
                option.equals("3");
                String option2 = in.nextLine();
                System.out.println("Add the name of the person you want to search:");
                menu1.SearchContact(option2);
                break;
            default:
                option.equals("4");
                break;
        }
        System.out.println("Thanks for use the Contact Manager");
    }
}




