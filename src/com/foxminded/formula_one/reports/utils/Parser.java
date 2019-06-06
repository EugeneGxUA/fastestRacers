package com.foxminded.formula_one.reports.utils;

import java.time.LocalDateTime;

import com.foxminded.formula_one.reports.models.Racer;

public class Parser {
    
    public Racer createRacerFromString(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstants.EMPTY_ARGUMENT);
        }
        if (!string.matches(ValidationPatternConstants.RACER_INFO)) {
            throw new IllegalArgumentException(ExceptionConstants.ARGUMENT_FORMAT);
        }
        
        String[] params = string.split("_");
        
        return new Racer(params[0], params[1], params[2]);
    }
    
    public LocalDateTime parseTimeDateFromString(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstants.EMPTY_ARGUMENT);
        }
        if (!dateTime.matches(ValidationPatternConstants.DATE_TIME)) {
            throw new IllegalArgumentException(ExceptionConstants.ARGUMENT_FORMAT);
        }
        
        return LocalDateTime.parse(dateTime, FormatConstants.DATE_FORMAT_PATTERN);
    }
}
