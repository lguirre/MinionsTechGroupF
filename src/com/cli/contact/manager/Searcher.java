package com.cli.contact.manager;
import com.cli.contact.model.Person;
import java.util.List;

public interface  Searcher {
    public List<Person> meetSearch(String key, List<Person> persons);
}

