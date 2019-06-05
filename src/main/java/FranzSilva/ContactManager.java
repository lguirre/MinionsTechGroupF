package FranzSilva;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ContactManager {
    private List<Contact> contactList;

    /**
     * Contact Manager Constructor.
     */
    public ContactManager() {
        contactList = new ArrayList<>();
    }

    /**
     * Adds Contact.
     *
     * @param contact - Contact to Add.
     */
    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    /**
     * Searchs the contact for name.
     *
     * @param name - Name to search.
     * @return list to the results.
     */
    public List<Contact> searchContact(String name) {
        List<Contact> contactListSearch = new ArrayList<>(contactList);
        return contactListSearch.stream().filter(customer -> customer.getName().contains(name)).collect(Collectors.toList());
    }

    /**
     * Gets Contact List.
     *
     * @return Contact List.
     */
    public List<Contact> getContactList(){
        return contactList;
    }

    /**
     * Shows all Contacts on specific Format.
     */
    public String showContacts(List<Contact> contactListToShow) {
        int numerator = 0;
        String format = "| %1$s. %2$s";
        StringJoiner stringJoiner;
        StringJoiner stringFinalResult = new StringJoiner("\n");
        stringFinalResult.add("| N.    Name         Email         Phone");
        for (Contact contact : contactListToShow) {
            stringJoiner = new StringJoiner(", ");
            if(!contact.getName().isEmpty() || contact.getName().length()>0){
                stringJoiner.add(contact.getName());
            }
            if(!contact.getEmail().isEmpty() || contact.getEmail().length()>0){
                stringJoiner.add(contact.getEmail());
            }
            if(!contact.getPhoneNumber().isEmpty() || contact.getPhoneNumber().length()>0){
                stringJoiner.add(contact.getPhoneNumber());
            }
            stringFinalResult.add(String.format(format, ++numerator, stringJoiner.toString()));
        }
        return stringFinalResult.toString();
    }

    /**
     * Removes to conctac with a specific name.
     *
     * @param name - name to eliminate.
     */
    public void removedContact(String name) {
        contactList.removeIf(contact -> contact.getName().contains(name));
    }
}
