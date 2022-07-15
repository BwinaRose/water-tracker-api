package com.codedifferently.watertrackerapi.domain.person.services;

import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.watertrackerapi.domain.person.models.Person;
import com.codedifferently.watertrackerapi.domain.person.repos.PersonRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepo personRepo;

    private Person mockPerson01;
    private Person savedPerson01;
    private Person savedPerson02;

    @BeforeEach
    public void setup(){
        mockPerson01 = new Person("Tariq", "Hook","wutang", 43, 250.0);

        savedPerson01 = new Person("Tariq", "Hook","wutang", 43, 250.0);
        savedPerson01.setId(1l);

        savedPerson02 = new Person("Derick", "Hook","TopBoy", 51, 180.0);
        savedPerson02.setId(2l);
    }

    @Test
    @DisplayName("Create Person - success")
    public void createPersonTest01(){
        BDDMockito.doReturn(Optional.empty()).when(personRepo).findByUserName(ArgumentMatchers.any());
        BDDMockito.doReturn(savedPerson01).when(personRepo).save(mockPerson01);
        Person person = personService.create(mockPerson01);
        Assertions.assertNotNull(person.getId());
    }

    @Test
    @DisplayName("Create Person - fail")
    public void createPersonTest02(){
        BDDMockito.doReturn(Optional.of(savedPerson01)).when(personRepo).findByUserName(ArgumentMatchers.any());
        BDDMockito.doReturn(savedPerson01).when(personRepo).save(mockPerson01);
        Assertions.assertThrows(ResourceCreationException.class, ()->{
            personService.create(mockPerson01);
        });
    }

    @Test
    @DisplayName("Get By Id - success")
    public void getPersonByIdTest01(){
        BDDMockito.doReturn(Optional.of(savedPerson01)).when(personRepo).findById(1l);
        Person person = personService.getById(1l);
        Assertions.assertNotNull(person);
    }

    @Test
    @DisplayName("Get By Id - fail")
    public void getPersonByIdTest02(){
        BDDMockito.doReturn(Optional.empty()).when(personRepo).findById(1l);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            personService.getById(1l);
        });
    }

    @Test
    @DisplayName("Get All People - success")
    public void getAllPeopleTest01(){
        List<Person> people = new ArrayList<>();
        people.add(savedPerson01);
        BDDMockito.doReturn(people).when(personRepo).findAll();
        List<Person> actualPeople = personService.getAllPeople();
        Integer expectedSize = 1;
        Integer actualSize = actualPeople.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("Get By Last name - success")
    public void getByLastNameTest01(){
        List<Person> people = new ArrayList<>();
        people.add(savedPerson01);
        people.add(savedPerson02);
        BDDMockito.doReturn(people).when(personRepo).findByLastName("Hook");
        List<Person> actualPeople = personService.getByLastName("Hook");
        Integer expected = 2;
        Integer actual = actualPeople.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get By Last name - fail")
    public void getByLastNameTest02(){
        List<Person> people = new ArrayList<>();
        BDDMockito.doReturn(people).when(personRepo).findByLastName("Hook");
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            List<Person> actualPeople = personService.getByLastName("Hook");
        });
    }

    @Test
    @DisplayName("Update User - Success")
    public void updateUserTest01(){
        Person updated = new Person("Tariq", "Hook","wutang", 44, 250.0);
        updated.setId(1l);
        BDDMockito.doReturn(Optional.of(savedPerson01)).when(personRepo).findById(1l);
        BDDMockito.doReturn(updated).when(personRepo).save(savedPerson01);
        Person actualPerson = personService.update(1l, savedPerson01);
        Integer expectedAge = 44;
        Integer actualAge = actualPerson.getAge();
        Assertions.assertEquals(expectedAge, actualAge);
    }


}
