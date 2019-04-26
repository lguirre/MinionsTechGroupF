/**
 * Class description.
 *
 * @author Jose Colina
 * @version 1.0.
 */
public class ContactsManager {
    // Fields:
    Contact [] myFriends;
    int friendsCount;

    // Constructor:
    ContactsManager(){
        friendsCount = 0;
        myFriends = new Contact[500];
    }

    // Methods:
    void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    Contact searchContact(String searchName){
        for(int i=0; i<friendsCount; i++){
            if(myFriends[i].name.equals(searchName)){
                return myFriends[i];
            }
        }
        return null;
    }
    Contact matchContact(String searchMatch){
        for(int i=0; i<friendsCount; i++){
            if(myFriends[i].name.contains(searchMatch)){
                return myFriends[i];
            }
        }
        return null;
    }
    Contact removeContact(String contactName){
        boolean found = false;
        Contact removed = null;
        for(int i=0; i<friendsCount; i++){
            if (found){
                myFriends[i-1] = myFriends[i];
                myFriends[i] = null;
            }
            else if(myFriends[i].name.equals(contactName)){
                removed = myFriends[i];
                myFriends[i] = null;
                found = true;
            }
        }
        if (found) {
            friendsCount--;
        }
        return removed;
    }
}
