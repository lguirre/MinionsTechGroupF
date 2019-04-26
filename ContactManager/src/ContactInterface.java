import java.util.Scanner;

public class ContactInterface {
    private Scanner scanner;
    private boolean salir;
    private ContactsManager contacts;

    public ContactInterface(){
        this.scanner = new Scanner(System.in);
        this.salir = false;
        this.contacts = new ContactsManager();
    }

    public void ContactMenu(){
        do {
            System.out.println("1. Save a Contact");
            System.out.println("2. Show Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete a Contact");
            System.out.println("5. Exit ");

            try {

                System.out.println("Select an Option");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        addContactInterface();
                        break;
                    case 2:
                        listAllContact();
                        break;
                    case 3:
                        searchContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("only Accept number from 1 to 5");
                        break;
                }
            } catch (Exception e) {
                System.out.println("only is accepted numbers");
                scanner.next();
            }
        }while (!salir);

    }

    private void searchContact() {
        System.out.println("Enter the Name to search");
        String name = scanner.next();
        contacts.searchAndPrintContact(name);
    }

    private void addContactInterface(){
        System.out.println("Enter the Name");
        String name = scanner.next();
        System.out.println("Enter the phone");
        String phone = scanner.next();
        System.out.println("Enter the email");
        String email = scanner.next();
        contacts.addContact(name,phone,email);

    }

    private void listAllContact(){
        contacts.printAllContacts();
    }

    private void deleteContact() {
        System.out.println("Enter the Name to delete");
        String name = scanner.next();
        boolean deleted = contacts.deleteContact(name);
        if (deleted == true)
            System.out.println("The contact was deleted successful");
        else
            System.out.println("The contact wasn't found");
    }
}
