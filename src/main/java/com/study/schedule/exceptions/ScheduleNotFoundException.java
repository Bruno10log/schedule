package com.study.schedule.exceptions;


public class ScheduleNotFoundException extends RuntimeException {

    ScheduleNotFoundException(Long id) {
        super("Could not found exception " + id);
    }
}
