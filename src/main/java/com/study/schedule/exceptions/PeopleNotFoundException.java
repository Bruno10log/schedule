package com.study.schedule.exceptions;

public class PeopleNotFoundException extends RuntimeException {

    public PeopleNotFoundException(String name) {
        super("Could not find person with name containing " + name);
    }
}
