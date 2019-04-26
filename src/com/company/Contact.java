package com.company;

public class Contact {
    String name;
    String telephone;
    String email;

    Contact(String nameContact, String telephoneContact, String emailContact){
        name=nameContact;
        telephone=telephoneContact;
        email=emailContact;
    }

    public String giveName(){
        return name;
    }
    public String giveTelephone(){
        return telephone;
    }
    public String giveEmail(){
        return email;
    }
}
