package com.codedifferently.watertrackerapi.domain.log.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class LogRequest {
    private String date;
}
