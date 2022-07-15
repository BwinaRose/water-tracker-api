package com.codedifferently.watertrackerapi.domain.person.services;

import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.watertrackerapi.domain.person.models.Person;
import com.codedifferently.watertrackerapi.domain.person.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person create(Person person) throws ResourceCreationException {
        Optional<Person> optional = personRepo.findByUserName(person.getUserName());
        if(optional.isPresent())
            throw new ResourceCreationException("User with username exists " + person.getUserName());
        return personRepo.save(person);
    }

    @Override
    public Person getById(Long id) throws ResourceNotFoundException {
       Person person = personRepo.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("User with id does not exists " + id));
        return person;
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

    @Override
    public List<Person> getByLastName(String lastName) throws ResourceNotFoundException {
        List<Person> people = (List) personRepo.findByLastName(lastName);
        if(people.size() == 0)
            throw new ResourceNotFoundException("No users with last name " + lastName);
        return people;
    }

    @Override
    public Person update(Long id, Person personDetail) throws ResourceNotFoundException {
        Person savedPerson = getById(id);
        savedPerson.setFirstName(personDetail.getFirstName());
        savedPerson.setLastName(personDetail.getLastName());
        savedPerson.setAge(personDetail.getAge());
        savedPerson.setUserName(personDetail.getUserName());
        savedPerson.setWeight(personDetail.getWeight());
        return personRepo.save(savedPerson);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Person person = getById(id);
        personRepo.delete(person);
    }
}
