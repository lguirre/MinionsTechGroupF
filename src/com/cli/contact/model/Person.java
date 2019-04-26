package com.cli.contact.model;

public class Person {
    private String name;
    private String lastName;
    private int phoneNumber;
    private String email;

    public Person(String name, String lastName, String email, int phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
