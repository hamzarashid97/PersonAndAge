package com.example.PersonAndAge;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }


    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getSpecificPerson(Integer personId) {
        return personRepository.findById(personId).orElse(null);

    }
    public Person createPerson(Person person) {
        person.setId(null);
        return personRepository.save(person);
    }

    public Person updatePerson(Integer personId, Person updatedPerson) {
        Person existing = personRepository.findById(personId).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setName(updatedPerson.getName());
        existing.setAddress(updatedPerson.getAddress());
        return personRepository.save(existing);
    }


    public boolean deletePerson(Integer personId) {
        if (!personRepository.existsById(personId)) {
            return false;
        }
        personRepository.deleteById(personId);
        return true;
    }
}
