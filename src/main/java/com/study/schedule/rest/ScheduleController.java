package com.study.schedule.rest;

import com.study.schedule.entities.Schedule;
import com.study.schedule.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule newSchedule) {
        return ResponseEntity.ok(repository.save(newSchedule));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Schedule>> getAll() {
        var schedules = repository.findAll();

        if(schedules.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(schedules);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") long id) {
        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
