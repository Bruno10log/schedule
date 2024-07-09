package com.study.schedule.advices;

import com.study.schedule.exceptions.PeopleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PeopleNotFoundAdvice {

    @ExceptionHandler(PeopleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String peopleNotFoundHandler(PeopleNotFoundException ex) {
        return ex.getMessage();
    }

}
