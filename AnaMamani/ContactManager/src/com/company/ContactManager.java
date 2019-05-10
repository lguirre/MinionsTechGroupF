package com.company;

public class ContactManager {
   public Contact[] myFriends;
   public int friendsCount;

   public ContactManager(){
       this.friendsCount= 0;
       this.myFriends=new Contact[500];
   }

    /**
     * Method for add contact
     * @param contact
     */
    public void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;

    }

    /**
     * Method for add Contact for name phone and email
     * @param name
     * @param phone
     * @param email
     */
    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name,phone,email);
        this.addContact(contact);
    }

    /**
     * Method for Search contact.
     * @param searchName
     * @return
     */
   public void searchContact(String searchName){
       for(int i = 0; i<friendsCount; i++){
           if(myFriends[i].getName().contains(searchName)){
               System.out.println(myFriends[i].printContact());
           }
           else
               System.out.println("Any Contact was found");
       }
   }

    /**
     * Method for show contacts
     */
    public void showContacts(){
        for(int i = 0; i<friendsCount; i++){
            Contact contact = myFriends[i];
            System.out.println(contact.printContact());
        }
    }
}
