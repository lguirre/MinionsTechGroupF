
public class ContactManager {
	Contact [] myFriends;
	int friendsCount;
	public ContactManager(){
		this.friendsCount = 0;
		this.myFriends = new Contact[500];
	}
	
	public void addContact(Contact contact){
		myFriends[friendsCount] = contact;
		friendsCount++;
	}
	
	public void showContacts(){
		for(int i = 0; i < friendsCount; i++){
			if(myFriends[i] != null){
				System.out.println((i)+".-"+" "+ myFriends[i].getName() +" "+ myFriends[i].getEmail() +" "+myFriends[i].getPhoneNumber());
			}
		}
	}
	
	public void searchContact(String word){
		for(int i=0; i<friendsCount; i++){
			if(myFriends[i].getName().contains(word)){
				System.out.println(myFriends[i].getName() +" "+myFriends[i].getPhoneNumber());
			}
		}
	}
	
	public void deleteContact(String nameContact){
		for(int i=0; i<friendsCount; i++){
			if(myFriends[i].getName().equals(nameContact)){
				myFriends[i] = null;
				System.out.println("deleted contact");
			}
		}
	}
}
