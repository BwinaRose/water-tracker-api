package com.codedifferently.watertrackerapi.domain.log.services;

import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.watertrackerapi.domain.log.models.Log;
import com.codedifferently.watertrackerapi.domain.log.models.LogRequest;
import com.codedifferently.watertrackerapi.domain.log.repos.LogRepo;
import com.codedifferently.watertrackerapi.domain.person.models.Person;
import com.codedifferently.watertrackerapi.domain.person.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@Slf4j
public class LogServiceImpl implements LogService{
    private PersonService personService;
    private LogRepo logRepo;

    @Autowired
    public LogServiceImpl(PersonService personService, LogRepo logRepo) {
        this.personService = personService;
        this.logRepo = logRepo;
    }

    @Override
    public Log create(Long personId, Log log) throws ResourceCreationException {
        Person person = personService.getById(personId);
        log.setPerson(person);
        return logRepo.save(log);
    }

    @Override
    public Iterable<Log> getByDate(Long peronId, LogRequest logRequest) {
        Iterable<Log> logs = null;
        try {
            Person person = personService.getById(peronId);
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String date = logRequest.getDate();
            Date startDate = format.parse(date + " 00:00:00'Z'");
            Date endDate = format.parse(date + " 23:59:59'Z'");
            log.info(startDate.toString());
            log.info(endDate.toString());
            logs = (List)logRepo.findByDateBetween(startDate, endDate);

        }catch (ParseException e) {
            e.printStackTrace();
        }
        return logs;
    }

    @Override
    public Iterable<Log> getAll() {
        return null;
    }
}
