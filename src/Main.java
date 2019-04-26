/**
 * Class description.
 *
 * @author Jose Colina
 * @version 1.0.
 */
public class Main {
    public static void main(String [] args){
//        ContactsManager myContactManager = new ContactsManager();
//        Contact contact1 = new Contact();
//        contact1.name = "Alan Brito";
//        contact1.phoneNumber = "800-666-123";
//        myContactManager.addContact(contact1);
//        Contact find = myContactManager.searchContact("Alan Brito");
//        System.out.println(find.name);

        ActionsMenu menu = new ActionsMenu();
        String option = "";
        do {
            menu.displayMenu();
            option = menu.readOption();
            //System.out.println("Option selected:" + menu.readOption());
            menu.runAction(option);
        }
        while (!option.equals("4"));
    }
}
