package com.backendspringboot.lockerapp.services;

import com.backendspringboot.lockerapp.models.Locker;

import java.util.List;

public interface LockerService {
    Locker saveLocker(Locker locker);
    List<Locker> getLockers();
    Locker getLockerById(long id);
    Locker updateLocker(Locker locker, long id);
    void deleteLocker(long id);


}
