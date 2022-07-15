package com.codedifferently.watertrackerapi.domain.person.services;

import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.watertrackerapi.domain.person.models.Person;
import com.codedifferently.watertrackerapi.domain.person.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Person getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Person> getAllPeople() {
        return null;
    }

    @Override
    public List<Person> getByLastName(String lastName) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Person update(Long id, Person personDetail) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {

    }
}
