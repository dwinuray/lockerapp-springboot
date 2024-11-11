package com.backendspringboot.lockerapp.services.impl;

import com.backendspringboot.lockerapp.models.Locker;
import com.backendspringboot.lockerapp.repository.LockerRepository;
import com.backendspringboot.lockerapp.services.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LockerServiceImpl implements LockerService {
    @Autowired
    private LockerRepository lockerRepository;

    // save locker in database
    @Override
    public Locker saveLocker(Locker locker) {
        return lockerRepository.save(locker);
    }

    // get all locker from database
    @Override
    public List<Locker> getLockers() {
        return lockerRepository.findLockersWithDeletedAtNull();
    }

    // get locker by id
    @Override
    public Locker getLockerById(long id) {
        Optional<Locker> locker = lockerRepository.findById(id);
        if ( locker.isPresent() ) {
            return locker.get();
        }else {

            throw new RuntimeException("No locker found with id " + id);
        }
    }


    // update locker
    @Override
    public Locker updateLocker(Locker locker, long id){
        Locker existingLocker = lockerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No locker found with id " + id)
        );

        existingLocker.setName(locker.getName());
        existingLocker.setPrice(locker.getPrice());
//        existingLocker.setUpdated_at(locker.getUpdated_at());
        existingLocker.setUpdatedAt(LocalDateTime.now());

        // save
        lockerRepository.save(existingLocker);
        return existingLocker;
    }


    // delete locker
    @Override
    public void deleteLocker(long id) {
        // check
        Locker existingLocker = lockerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No locker found with id " + id)
        );

        existingLocker.setDeletedAt(LocalDateTime.now());
        lockerRepository.save(existingLocker);
    }

}
