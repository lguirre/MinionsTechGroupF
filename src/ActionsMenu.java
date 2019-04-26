/**
 * Class description.
 *
 * @author Jose Colina
 * @version 1.0.
 */
import java.util.Scanner;
public class ActionsMenu {
    private Scanner scannerIn;
    private String selectedOption;
    private ContactsManager contactsManager;

    ActionsMenu(){
        scannerIn= new Scanner(System.in);
        contactsManager = new ContactsManager();
    }
    public void displayMenu(){
        System.out.println("Select an action:\n" +
                "1. Add contact\n"+
                "2. Show contacts\n"+
                "3. Search contact\n"+
                "4. Remove contact\n"+
                "5. Exit\n");
    }
    public String readOption(){
        selectedOption = scannerIn.nextLine();
        return selectedOption;
    }
    public void runAction(String option){
        switch (option){
            case "1":
                //System.out.println("Add option selected\n");
                addOption();
                break;
            case "2":
                //System.out.println("Show option selected\n");
                showContacts();
                break;
            case "3":
                //System.out.println("Search option selected\n");
                searchContact();
                break;
            case "4":
                //System.out.println("Remove contact\n");
                removeContact();
                break;
            case "5":
                System.out.println("Exit program...\n");
                break;
            default:
                System.out.println("Wrong option selected\n");
                break;
        }

    }
    public void addOption(){
        Contact newContact = new Contact();
        do{
            System.out.println("Enter contact name:\n");
            newContact.name = scannerIn.nextLine();
            if (newContact.name.equals(""))
                System.out.println("Name cannot be empty, try again");
        }
        while(newContact.name.equals(""));
        System.out.println("Enter contact phone:\n");
        newContact.phoneNumber = scannerIn.nextLine();
        System.out.println("Enter contact email address:\n");
        newContact.email = scannerIn.nextLine();
        System.out.println("New contact created successfully\n");
        contactsManager.addContact(newContact);
    }
    public void showContacts(){
        if (contactsManager.friendsCount > 0) {
            System.out.println("Contacts list:");
            for (int i = 0; i < contactsManager.friendsCount; i++) {
                System.out.print((i + 1) + "." + "\t" + contactsManager.myFriends[i].name);
                if (!contactsManager.myFriends[i].phoneNumber.equals(""))
                    System.out.print( ", " + contactsManager.myFriends[i].phoneNumber);
                if (!contactsManager.myFriends[i].email.equals(""))
                    System.out.print( ", " + contactsManager.myFriends[i].email);
                System.out.println("\n");
            }
        }
        else{
            System.out.println("No contacts stored\n");
        }

    }
    public void searchContact(){
        Contact foundContact;
        System.out.println("Enter contact name:");
        foundContact = contactsManager.matchContact(scannerIn.nextLine());
        if (foundContact != null){
            System.out.println("Contact found:\n" +
                    foundContact.name + ", "
                    + foundContact.phoneNumber+ ", "
                    + foundContact.email + "\n");
        }
        else{
            System.out.println("Contact not found\n");
        }

    }
    public void removeContact(){
        Contact removed;
        System.out.println("Enter contact name to be deleted:");
        removed = contactsManager.removeContact(scannerIn.nextLine());
        if (removed != null){
            System.out.println("Contact removed:");
            System.out.print(removed.name);
            if (!removed.phoneNumber.equals(""))
                System.out.print( ", " + removed.phoneNumber);
            if (!removed.email.equals(""))
                System.out.print( ", " + removed.email);
            System.out.println("\n");
        }
        else{
            System.out.println("Contact not found");
        }
    }
}
