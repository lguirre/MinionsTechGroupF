import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manager of the contacts.
 */
public class ContactManager {

    private List<Contact> contacts;

    /**
     * The constructor.
     */
    public ContactManager() {
        contacts = new ArrayList<>();
    }

    /**
     * Adds contact.
     * @param contact the contact object.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /***
     * Search contacts.
     * @param searchName key to search.
     * @return List with all maches.
     */
    public List<Contact> searchContact(String searchName) {
        List<Contact> foundContacts = contacts.stream()
            .filter(contact -> contact.contains(searchName))
            .collect(Collectors.toList());
        return foundContacts;
    }

    /**
     * Delete contacts.
     * @param name name to delete.
     */
    public void deleteContact(String name) {
        contacts = contacts.stream()
            .filter(contact -> !contact.getName().equalsIgnoreCase(name))
            .collect(Collectors.toList());
    }

    /**
     * Displays contacts.
     */
    public void displayContact() {
        contacts.stream().forEach(System.out::println);
    }
}
