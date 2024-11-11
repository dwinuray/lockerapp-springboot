package com.backendspringboot.lockerapp.services;

import com.backendspringboot.lockerapp.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    User findById(long id);
//    User update(User user);
    void delete(long id);
}
