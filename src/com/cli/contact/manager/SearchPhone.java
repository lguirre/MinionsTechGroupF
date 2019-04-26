package com.cli.contact.manager;

import com.cli.contact.model.Person;

import java.util.ArrayList;
import java.util.List;

public class SearchPhone implements Searcher {
    @Override
    public List<Person> meetSearch(String key, List<Person> persons) {
        List<Person> meetPersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getPhoneNumber() == Integer.parseInt(key)){
                meetPersons.add(person);
            }
        }
        return meetPersons;
    }
}
