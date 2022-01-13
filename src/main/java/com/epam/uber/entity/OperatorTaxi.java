package com.epam.uber.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OperatorTaxi {

    private static OperatorTaxi instance;
    private static final Lock lock =new ReentrantLock();
    private final List<Car> cars = new ArrayList<>();

    public static OperatorTaxi getInstance() {
        OperatorTaxi localInstance = instance;

        if (localInstance == null) {
            lock.lock();
            localInstance = instance;
            try {
                if (localInstance == null) {
                    localInstance = new OperatorTaxi();
                    localInstance.initialize();
                    instance = localInstance;
                }
            } finally {
                lock.unlock();
            }
        }
        return localInstance;
    }

    private void initialize() {
// разобраться с лямбдой
    }

    public List<Car> getCars() {
        return cars;
    }
}
