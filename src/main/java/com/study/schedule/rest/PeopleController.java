package com.study.schedule.rest;

import com.study.schedule.entities.Person;
import com.study.schedule.exceptions.PeopleNotFoundException;
import com.study.schedule.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people/")
public class PeopleController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/all")
    public List<Person> getAll() {
        return repository.findAll();
    }

    @GetMapping("/search/{name}")
    public List<Person> getByName(@PathVariable String name) {
        var people = repository.findByNameContaining(name);

        if(people.isEmpty()) {
            throw new PeopleNotFoundException(name);
        }

        return people;

    }

    @PostMapping("/create")
    public void create(@RequestBody Person newPerson) {
        repository.save(newPerson);
    }

    @PutMapping("/update/{id}")
    public Person update(@RequestBody Person newPerson, @PathVariable Long id) {
        return repository.findById(id)
                            .map(person -> {
                                person.setName(newPerson.getName());
                                person.setEmailAddress(newPerson.getEmailAddress());
                                person.setPhoneNumber(newPerson.getPhoneNumber());

                                return repository.save(person);
                            }).orElseGet(() -> repository.save(newPerson));
    }
}
