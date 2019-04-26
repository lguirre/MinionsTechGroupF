public class ContactsManager {
    Contact [] myFriends;
    int friendsCount;

    ContactsManager(){
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }

    void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    void searchContact(String searchName){
        for(int i=0; i<friendsCount; i++){
            if(myFriends[i].name.toLowerCase().contains(searchName.toLowerCase())){
                System.out.println(myFriends[i].name +" "+myFriends[i].phoneNumber+" "+myFriends[i].email);
            }
        }
    }
}
