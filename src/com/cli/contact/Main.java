package com.cli.contact;

import com.cli.contact.manager.SearchLastName;
import com.cli.contact.manager.SearchOnlyLetter;
import com.cli.contact.manager.SearchPhone;
import com.cli.contact.manager.Searcher;
import com.cli.contact.model.Contact;
import com.cli.contact.model.Person;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("angelica","lopez","anghe@gmail.com",4287052);
        Person p2 = new Person("daniel","cespedes","daniel@gmail.com",2287052);
        Person p3 = new Person("carlos","mayta","carlos@gmail.com",3287052);
        Person p4 = new Person("sofia","perez","sofi@gmail.com",5287052);

        Contact contact = new Contact();
        contact.addContact(p1);
        contact.addContact(p2);
        contact.addContact(p3);
        contact.addContact(p4);

            int choice = 0;

            while (choice != 4)
            {   System.out.println();
                showMenu();
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Please input the data for a new user as. e.g. loana lopez, 4287059, loan@gmail.com ");
                    String name = "", lastName = "", phone = "", email = "";
                    System.out.println("Introduce Name: ");
                    name = scanner.next();
                    System.out.println("Introduce Last Name: ");
                    lastName = scanner.next();
                    System.out.println("Introduce Phone: ");
                    phone = scanner.next();
                    System.out.println("Introduce Email: ");
                    email = scanner.next();

                    try{
                        Person newPerson = new Person(name, lastName, email, Integer.parseInt(phone));
                        contact.addContact(newPerson);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Phone number bad introduced, sorry! trying again!");
                    }
                } else if (choice == 2) {
                    System.out.println("List Contacts:");

                    List<Person> allContact = contact.getContacts();

                    for (Person person : allContact
                    ) {
                        showPerson(person);
                    }
                } else if (choice == 3) {
                    showSubMenu();

                    int choiseSearch = scanner.nextInt();

                    if (choiseSearch == 1) {
                        Searcher searcher = new SearchLastName();
                        System.out.println("Introduce Name or Last Name:");
                        String nameLast = scanner.next();
                        List<Person> personList = searcher.meetSearch(nameLast, contact.getContacts());

                        for (Person person : personList
                        ) {
                            showPerson(person);
                        }
                    } else if (choiseSearch == 2) {
                        Searcher searcher = new SearchOnlyLetter();
                        System.out.println("Introduce a Letter:");
                        String keyLetter = scanner.next();
                        List<Person> personList = searcher.meetSearch(keyLetter, contact.getContacts());

                        for (Person person : personList
                        ) {
                            showPerson(person);
                        }
                    } else if (choiseSearch == 3) {
                        Searcher searcher = new SearchPhone();
                        System.out.println("Introduce a Phone to search:");
                        String phoneNumber = scanner.next();
                        List<Person> personList = searcher.meetSearch(phoneNumber, contact.getContacts());

                        for (Person person : personList
                        ) {
                            showPerson(person);
                        }
                    }
                }
            }
            System.out.println("Thank you! Good Bye.");
    }

    public static void showMenu(){
        System.out.println("|   MENU SELECTION         |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Add Contact    |");
        System.out.println("|        2. Show Contacts  |");
        System.out.println("|        3. Search Contact |");
        System.out.println("|        4. Exit           |");
    }

    public static void showSubMenu(){
        System.out.println("| Options Search:                |");
        System.out.println("|        1. By Name or Last Name |");
        System.out.println("|        2. By Letter            |");
        System.out.println("|        3. By Phone Number      |");
        System.out.println("|        4. Exit                 |");
    }

    public static void showPerson(Person person){
        System.out.print(person.getName() + " ");
        System.out.print(person.getLastName() + ", ");
        System.out.print(person.getPhoneNumber() + ", ");
        System.out.println(person.getEmail());
    }
}