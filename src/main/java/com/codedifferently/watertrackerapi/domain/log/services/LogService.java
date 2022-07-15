package com.codedifferently.watertrackerapi.domain.log.services;

import com.codedifferently.watertrackerapi.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.watertrackerapi.domain.log.models.Log;
import com.codedifferently.watertrackerapi.domain.log.models.LogRequest;

import java.util.Date;

public interface LogService {
    Log create(Long personId, Log log) throws ResourceCreationException;
    Iterable<Log> getByDate(Long peronId, LogRequest logRequest);
    Iterable<Log> getAll();
}
