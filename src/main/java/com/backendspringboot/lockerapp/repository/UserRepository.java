package com.backendspringboot.lockerapp.repository;

import com.backendspringboot.lockerapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.deletedAt IS NULL")
    List<User> findUsers();
}
