package com.company;

public class Contact {
    public String name;
    public String email;
    public String phoneNumber;

    //Constructor
    public Contact(String name, String phoneNumber){
        this.name =name;
        this.phoneNumber= phoneNumber;

    }
    //Constructor
    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String printContact(){
        return name + " " + phoneNumber + " " + email;
    }
}
