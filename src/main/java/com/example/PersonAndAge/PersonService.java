package com.example.PersonAndAge;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    private final Map<Integer, Person> personDataBase = new HashMap<>();
    private static int id = 1;

    public PersonService() {

    }


    public List<Person> getAllPersons() {
        return new ArrayList<>(personDataBase.values());
    }

    public Person getSpecificPerson(Integer personId) {
        return personDataBase.get(personId);

    }
    public Person createPerson(Person person) {
        person.setId(id);
        personDataBase.put(id, person);
        id++;

        return person;
    }
}
