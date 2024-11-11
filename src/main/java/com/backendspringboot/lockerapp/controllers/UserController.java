package com.backendspringboot.lockerapp.controllers;


import com.backendspringboot.lockerapp.models.Locker;
import com.backendspringboot.lockerapp.models.User;
import com.backendspringboot.lockerapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }

    // get all
    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }


    // delete
    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@PathVariable long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
