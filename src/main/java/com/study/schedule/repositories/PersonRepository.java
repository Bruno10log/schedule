package com.study.schedule.repositories;

import com.study.schedule.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByNameContaining(String name);

}
