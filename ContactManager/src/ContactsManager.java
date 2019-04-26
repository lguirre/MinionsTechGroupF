public class ContactsManager {
    //fields
    private Contact [] myFriends;
    private int friendCount;
    //Constructor
    public ContactsManager(){
        this.friendCount = 0;
        this.myFriends = new Contact[500];

    }

    //Methods
    public void addContact(Contact contact){
        myFriends[friendCount] = contact;
        friendCount++;

    }

    public Contact[] searchContacts(String searchName){
        Contact found[] = new Contact[500];
        int counter = 0;
        for(int i = 0; i<friendCount; i++){
            if(myFriends[i].getName().contains(searchName)){
                found[counter] = myFriends[i];
                counter++;

            }
        }
        return found;
    }

    public void searchAndPrintContact(String searchName){
        for(int i = 0; i<friendCount; i++){
            if(myFriends[i].getName().contains(searchName)){
                System.out.println(myFriends[i].printContact());
            }
            else
                System.out.println("Any Contact was found");
        }

    }

    public void printAllContacts(){
        for(int i = 0; i<friendCount; i++){
            Contact contact = myFriends[i];
            System.out.println(contact.printContact());
            }

    }

    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name,phone,email);
        this.addContact(contact);
    }

    public boolean deleteContact(String name){
        boolean delete = false;
        Contact newFriendList[] = new Contact[500];
        int index = 0;
        for (int i = 0; i < friendCount ; i++) {
            if (myFriends[i].getName().equals(name)){
                delete = true;
            }
            else {
                newFriendList[index] = myFriends[i];
                index ++;
            }
        }
        friendCount = index;
        myFriends = newFriendList;
        return delete;
    }
}
