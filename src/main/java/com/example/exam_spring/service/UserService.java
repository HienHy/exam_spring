package com.example.exam_spring.service;

import com.example.exam_spring.entity.User;
import com.example.exam_spring.repository.UserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class UserService {

    final
    UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser(){
     return userRepo.findAll();
    }


    public List<User> searchUser(String name){
        return userRepo.findAllByNameContaining(name);

    }
    public Optional<User> searchById(Long id)
    {
       return userRepo.findById(id);
    }


    public User createUser(User user) {
        return userRepo.save(user);
    }


    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public User updateUser(User user, Long id) {
        return userRepo.findById(id).

                map(p -> {
                    p.setName(user.getName());
                    p.setAge(user.getAge());
                    p.setSalary(user.getSalary());
                    return userRepo.save(p);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepo.save(user);
                });
    }





}
