package com.codedifferently.watertrackerapi.domain.log.repos;

import com.codedifferently.watertrackerapi.domain.log.models.Log;
import com.codedifferently.watertrackerapi.domain.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface LogRepo extends JpaRepository <Log, Long>{
    Iterable<Log> findByPerson(Person person);
    Iterable<Log> findByDateBetween(Date startDate, Date endDate);
}
