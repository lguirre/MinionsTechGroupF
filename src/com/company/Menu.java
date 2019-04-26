package com.company;

public class Menu {
    Contact [] listContacts;
    int position;

    Menu(){
        position = 0;
        listContacts = new Contact[500];
    }

    public void AddContact(Contact newUser){
       for (int i = 0; i < position; i++) {
           listContacts[position] = newUser;
           position++;
       }
       System.out.println("User added successfully"+ listContacts[position]);

    }

    public void ShowContact(){
        int index=0;
        do{
            System.out.println(listContacts[index]);
            index++;
        }while(listContacts[index].name.equals("")!= false);

    }
    public void SearchContact(String searchName) {
        for (int i = 0; i < position; i++) {
            if (listContacts[i].name.equals(searchName)) {
                System.out.println("User found:"+ listContacts[i]);
            }
        }
        System.out.println("User don't found");
    }
}
