package com.study.schedule.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SCHEDULES")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(name = "DATE_AND_HOUR")
    private LocalDateTime dateAndHour;

    @OneToMany
    private List<Person> people;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateAndHour() {
        return dateAndHour;
    }

    public void setDateAndHour(LocalDateTime dateAndHour) {
        this.dateAndHour = dateAndHour;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
