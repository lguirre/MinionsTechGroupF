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
                "4. Exit\n");
    }
    public String readOption(){
        selectedOption = scannerIn.nextLine();
        return selectedOption;
    }
    public void runAction(String option){
        switch (option){
            case "1":
                System.out.println("Add option selected\n");
                addOption();
                break;
            case "2":
                System.out.println("Show option selected\n");
                showContacts();
                break;
            case "3":
                System.out.println("Search option selected\n");
                searchContact();
                break;
            case "4":
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
        for(int i=0; i<contactsManager.friendsCount; i++){
            System.out.println((i + 1) + "." + "\t" + contactsManager.myFriends[i].name + ", "
                    + contactsManager.myFriends[i].phoneNumber + ", "
                    + contactsManager.myFriends[i].email);
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
}
