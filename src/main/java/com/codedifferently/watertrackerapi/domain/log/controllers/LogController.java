package com.codedifferently.watertrackerapi.domain.log.controllers;

import com.codedifferently.watertrackerapi.domain.log.models.Log;
import com.codedifferently.watertrackerapi.domain.log.models.LogRequest;
import com.codedifferently.watertrackerapi.domain.log.services.LogService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/logs")
@Slf4j
public class LogController {

    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("{personId}")
    public ResponseEntity<Iterable<Log>> getAllLogsForCurrentDay(@PathVariable("personId")Long personId, @RequestBody LogRequest logRequest){
        Iterable<Log> logs = logService.getByDate(personId, logRequest);
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @PostMapping("{personId}")
    public ResponseEntity<Log> createLogForCurrentDay(@PathVariable("personId") Long personId, @RequestBody Log log){
        log = logService.create(personId, log);
        return new ResponseEntity<>(log, HttpStatus.CREATED);
    }


}
