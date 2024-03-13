package com.example.exam_spring.controller;

import com.example.exam_spring.entity.User;
import com.example.exam_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;




    @GetMapping
    public List<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.searchById(id);
    }

    @GetMapping("/search")
    public List<User> getAllByName( String name) {
        return userService.searchUser(name);
    }




    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);

    }

    //creating put mapping that updates the book detail
    @PutMapping("/update")
    public User updateUser(@RequestBody User user, @RequestParam("id") Long id) {
        return userService.updateUser(user, id);
    }


}
