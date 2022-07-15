package com.codedifferently.watertrackerapi.domain.person.controllers;

import com.codedifferently.watertrackerapi.domain.person.models.Person;
import com.codedifferently.watertrackerapi.domain.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person){
        person = personService.create(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
