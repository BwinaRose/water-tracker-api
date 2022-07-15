package com.codedifferently.watertrackerapi.domain.person.repos;

import com.codedifferently.watertrackerapi.domain.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findByUserName(String userName);
}
