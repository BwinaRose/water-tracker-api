package com.codedifferently.watertrackerapi.domain.person.controllers;

import com.codedifferently.watertrackerapi.domain.person.models.Person;
import com.codedifferently.watertrackerapi.domain.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
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

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAll(){
        Iterable<Person> people = personService.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") Long id){
        Person person = personService.getById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updated(@PathVariable("id") Long id, @RequestBody Person personDetail){
        Person person = personService.update(id, personDetail);
        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
