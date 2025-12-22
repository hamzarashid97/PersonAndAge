package com.example.PersonAndAge;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();

        return ResponseEntity.ok(persons);

    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getSpecificPerson(@PathVariable("id") Integer personId) {
        Person person = personService.getSpecificPerson(personId);
        if (person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(person);

    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);


    }

}
