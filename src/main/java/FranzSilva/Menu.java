package FranzSilva;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Contact contact;
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("------------ MENU ------------");
            System.out.println("choose number of the option");
            System.out.println("1  Add Contact\n2  Show Contacts List\n3  Search Contact\n4  Delete Contact\n5  Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("------------ INSERT NEW CONTACT INFORMATION: ------------");
                    System.out.println("Insert Name");
                    name = scanner.next();
                    System.out.println("Insert LastName");
                    contact = new Contact(name.concat(" ").concat(scanner.next()));
                    System.out.println("Insert email");
                    contact.setEmail(scanner.next());
                    System.out.println("Insert Phone Number");
                    contact.setPhoneNumber(scanner.next());
                    contactManager.addContact(contact);
                    contactManager.showContacts(contactManager.getContactList());
                    break;
                case 2:
                    System.out.println("------------ CONTACTS LIST: ------------");
                    contactManager.showContacts(contactManager.getContactList());
                    break;
                case 3:
                    System.out.println("------------ SEARCH CONTACT: ------------");
                    System.out.println("insert name to search");
                    contactManager.showContacts(contactManager.searchContact(scanner.next()));
                    break;
                case 4:
                    System.out.println("------------ REMOVE CONTACT: ------------");
                    System.out.println("insert contact name to remove");
                    contactManager.removedContact(scanner.next());
                    break;
                case 5:
                    return;
            }
        }
    }
}
