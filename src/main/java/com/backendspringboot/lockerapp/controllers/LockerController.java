package com.backendspringboot.lockerapp.controllers;

import com.backendspringboot.lockerapp.models.Locker;
import com.backendspringboot.lockerapp.services.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/lockers")
public class LockerController {

    @Autowired
    private LockerService lockerService;

    @PostMapping
    public ResponseEntity<Locker> saveLocker(@RequestBody Locker locker) {
        return new ResponseEntity<Locker>(lockerService.saveLocker(locker), HttpStatus.CREATED);
    }

    // get all
    @GetMapping
    public List<Locker> getAllLockers() {
        return lockerService.getLockers();
    }


    @GetMapping("{id}")
    public ResponseEntity<Locker> getLockerById(@PathVariable Long id) {
        return new ResponseEntity<>(lockerService.getLockerById(id), HttpStatus.OK);
    }

    // update
    @PutMapping("{id}")
    public ResponseEntity<Locker> updateLocker(@PathVariable Long id, @RequestBody Locker locker) {
        return new ResponseEntity<Locker>(lockerService.updateLocker(locker, id), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("{id}")
    public ResponseEntity<Locker> deleteLocker(@PathVariable Long id) {
        lockerService.deleteLocker(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
