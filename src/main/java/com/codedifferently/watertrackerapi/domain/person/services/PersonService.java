package com.codedifferently.watertrackerapi.domain.person.services;

import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.watertrackerapi.domain.person.models.Person;

import java.util.List;

public interface PersonService {
    Person create(Person person) throws ResourceCreationException;
    Person getById(Long id) throws ResourceNotFoundException;
    List<Person> getAllPeople();
    List<Person> getByLastName(String lastName) throws ResourceNotFoundException;
    Person update(Long id, Person personDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
