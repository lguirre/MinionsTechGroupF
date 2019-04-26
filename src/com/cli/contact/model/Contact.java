package com.cli.contact.model;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private List<Person> contacts;

    public Contact() {
        this.contacts = new ArrayList<Person>();
    }

    public List<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person person) {
        contacts.add(person);
    }
}
