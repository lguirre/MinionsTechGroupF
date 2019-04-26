package com.cli.contact.manager;

import com.cli.contact.model.Person;
import java.util.ArrayList;
import java.util.List;

public class SearchLastName implements Searcher {
    @Override
    public List<Person> meetSearch(String key, List<Person> persons) {
        List<Person> meetPersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getName().equalsIgnoreCase(key) || person.getLastName().equalsIgnoreCase(key) || person.getEmail().equalsIgnoreCase(key)){
                meetPersons.add(person);
            }
        }
        return meetPersons;
    }
}
