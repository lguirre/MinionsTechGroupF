public class ContactsManager {
    //campos
    private Contact [] myFriends;
    private int friendsCount;


    //constructor
    ContactsManager(){
        friendsCount = 0;
        myFriends = new Contact[500];
    }

    // Metodos:
    public void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    public void showContact(){
        for(int i=0; i<friendsCount; i++){

            System.out.println(i + " " + myFriends[i].name + " " + myFriends[i].phoneNumber + " " + myFriends[i].email);

        }
    }



    public void deleteContact(String searchName){

        for(int i=0; i<friendsCount; i++){
            if(myFriends[i].name.equals(searchName)){
                int t=i;
                for(int r=i+1; r<friendsCount; r++) {

                    myFriends[t] = myFriends[r];

                    t++;
                }
                friendsCount--;
            }
        }
    }
    public Contact searchContact(String searchName){

            for (int i = 0; i < friendsCount; i++) {
                if (myFriends[i].name.equals(searchName)) {
                    return myFriends[i];

                }
            }
            return null;




    }


}