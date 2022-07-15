package com.codedifferently.watertrackerapi.domain.log.repos;

import com.codedifferently.watertrackerapi.domain.log.models.Log;
import com.codedifferently.watertrackerapi.domain.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogRepo extends JpaRepository <Log, Long>{
    Iterable<Log> findByPerson(Person person);
}
