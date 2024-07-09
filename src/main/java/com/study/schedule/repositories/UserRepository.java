package com.study.schedule.repositories;

import com.study.schedule.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String login);

}
