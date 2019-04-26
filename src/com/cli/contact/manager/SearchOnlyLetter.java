package com.cli.contact.manager;

import com.cli.contact.model.Person;

import java.util.ArrayList;
import java.util.List;

public class SearchOnlyLetter implements Searcher {
    @Override
    public List<Person> meetSearch(String key, List<Person> persons) {
        List<Person> meetPersons = new ArrayList<Person>();

        for (Person person : persons) {
            if (exist(person, key)) meetPersons.add(person);
        }
        return meetPersons;
    }

    public boolean exist(Person person,String key){

        boolean exist = false;
        char charAtKey = key.charAt(0);
        if (person.getName().charAt(0) == charAtKey){ exist = true;}
        if (person.getLastName().charAt(0) == charAtKey){ exist = true;}
        if (person.getEmail().charAt(0) == charAtKey){ exist = true;}

        return exist;
    }
}

