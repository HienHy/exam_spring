package com.example.exam_spring.repository;

import com.example.exam_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//
//List<User> findByName();
//List<User> findByAge();
List<User> findAllByNameContaining(String name);
}
