package com.backendspringboot.lockerapp.repository;

import com.backendspringboot.lockerapp.models.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LockerRepository extends JpaRepository<Locker, Long> {

    // Custom query to get lockers where deleted_at is null
    @Query("SELECT l FROM Locker l WHERE l.deletedAt IS NULL")
    List<Locker> findLockersWithDeletedAtNull();
}
