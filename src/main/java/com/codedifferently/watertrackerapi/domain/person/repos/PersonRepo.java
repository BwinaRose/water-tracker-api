package com.codedifferently.watertrackerapi.domain.person.repos;

import com.codedifferently.watertrackerapi.domain.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
