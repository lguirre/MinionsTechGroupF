public class Main {
    public static void main(String[] args){

//        Contact contact1 = new Contact("Julian", "785236941");
//        Contact contact2 = new Contact("Pepe","782369425");
//        Contact contact3 = new Contact("Jenifer", "jenifer@email.com", "789315325");
//        ContactsManager myContactManager = new ContactsManager();
//        myContactManager.addContact(contact1);
//        myContactManager.addContact(contact2);
//        myContactManager.addContact(contact3);
//        Contact contactFound = myContactManager.searchContact("Julian");
//        System.out.println(contactFound.getPhoneNumber());
//
//        myContactManager.printAllContacts();


        ContactInterface contacts = new ContactInterface();
        contacts.ContactMenu();
    }
}
