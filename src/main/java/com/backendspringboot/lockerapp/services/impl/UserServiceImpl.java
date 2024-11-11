package com.backendspringboot.lockerapp.services.impl;

import com.backendspringboot.lockerapp.models.Locker;
import com.backendspringboot.lockerapp.models.User;
import com.backendspringboot.lockerapp.repository.UserRepository;
import com.backendspringboot.lockerapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    // get all users from database
    @Override
    public List<User> findAll(){
        return userRepository.findUsers();
    }

    // get users by id
    @Override
    public User findById( long id ){
        Optional<User> user = userRepository.findById(id);
        if ( user.isPresent() ) {
            return user.get();
        } else {
            throw new RuntimeException("No user found with id " + id);
        }
    }

    // update user
//    @Override
//    public User update(User user, long id){
//        User existingUser = userRepository.findById(id).orElseThrow(
//                () -> new RuntimeException("No user found with id " + id)
//        );
//
//        // add attr ...
//        return existingUser;
//    }


    // delete user
    @Override
    public void delete(long id) {
        // check
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No user found with id " + id)
        );

        existingUser.setDeletedAt(LocalDateTime.now());
        userRepository.save(existingUser);
    }
}
