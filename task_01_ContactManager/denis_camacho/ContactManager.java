package denis_camacho;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> myFriends;
    int friendsCount;

    ContactManager() {
        this.myFriends = new ArrayList<>();
        this.friendsCount = 0;
    }

    public void addContact(Contact contact) {
        myFriends.add(contact);
        friendsCount++;
    }

    public Contact searchContact(String searchName) {
        for (Contact contact : myFriends) {
            if (contact.getName().equals(searchName)) {
                return contact;
            }
        }
        return null;
    }

    public void showContact() {
        System.out.println("| Name    | Number   | Email       | \n ---------------------------------------");
        for (Contact contact : myFriends) {
            System.out.println(String.format("| %s   | %s  | %s  |", contact.getName(), contact.getPhoneNumber(), contact.getEmail()));
        }
    }

    public boolean deleteContact(String name) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends.get(i).getName().equals(name)) {
                myFriends.remove(i);
                friendsCount--;
                System.out.println(String.format("The contact %s was deleted", name));
                return true;
            }
        }
        System.out.println(String.format("The contact %s didn't found", name));
        return false;
    }
}
