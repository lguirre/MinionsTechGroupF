import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Class that manage the contact manage object.
 */
public class Menu {

    Scanner in = new Scanner(System.in);
    ContactManager myContactManager;
    private final Map<String, Supplier<Boolean>> map = new HashMap<>();

    {
        map.put("1", this::addContact);
        map.put("2", this::deleteContact);
        map.put("3", this::searchContact);
        map.put("4", this::displayContact);
    }

    /**
     * starts the execution.
     */
    public void start() {
        myContactManager = new ContactManager();
        String yourOption = "";
        do {
            menuDisplay();
            yourOption = in.nextLine();
            if (map.containsKey(yourOption)) {
                map.get(yourOption).get();
            }
        } while (!yourOption.equalsIgnoreCase("0"));
    }

    /**
     * Adds contacts.
     * @return boolean value.
     */
    private boolean addContact() {
        String name;
        String email;
        String phone;
        System.out.println("ADDING CONTACTS");
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter email: ");
        email = in.nextLine();
        System.out.print("Enter phone number: ");
        phone = in.nextLine();
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setPhoneNumber(phone);
        myContactManager.addContact(contact);
        return true;
    }

    /**
     * Displays all contacts.
     * @return boolean value.
     */
    private boolean displayContact() {
        System.out.println("ALL CONTACTS");
        myContactManager.displayContact();
        return true;
    }

    /**
     * Search contacts.
     * @return boolean value.
     */
    private boolean searchContact() {
        String searchName;
        System.out.println("SEARCHING CONTACTS");
        System.out.print("Enter the search word: ");
        searchName = in.nextLine();
        List<Contact> searchList = myContactManager.searchContact(searchName);
        System.out.println("CONTACTS FOUND ");
        searchList.stream().forEach(System.out::println);
        return true;

    }

    /**
     * Deletes contact.
     * @return boolean value.
     */
    private boolean deleteContact() {
        String name;
        System.out.println("DELETING CONTACTS");
        System.out.print("Enter name: ");
        name = in.nextLine();
        myContactManager.deleteContact(name);
        System.out.println(String.format("Your contact '%s' was delete.", name));
        return true;
    }

    /**
     * Displays the menu.
     */
    private void menuDisplay() {
        System.out.println("MENU");
        System.out.println("1.- Add contact.");
        System.out.println("2.- Delete contact.");
        System.out.println("3.- Search contact.");
        System.out.println("4.- Display contact.");
        System.out.println("0.- End program.");
        System.out.print("Enter your option: ");
    }
}
