package com.epam.uber.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
    public double getxCoordinateOfCar() {
        return xCoordinateOfCar;
    }

    public void setxCoordinateOfCar(double xCoordinateOfCar) {
        this.xCoordinateOfCar = xCoordinateOfCar;
    }

    public double getyCoordinateOfCar() {
        return yCoordinateOfCar;
    }

    public void setyCoordinateOfCar(double yCoordinateOfCar) {
        this.yCoordinateOfCar = yCoordinateOfCar;
    }

    private double xCoordinateOfCar;
    private double yCoordinateOfCar;
    private static Car instance;
    private static final Lock lock =new ReentrantLock();
    private final List<Operator> operators = new ArrayList<>();

    public static Car getInstance() {
        Car localInstance = instance;

        if (localInstance == null) {
            lock.lock();
            localInstance = instance;
            try {
                if (localInstance == null) {
                    localInstance = new Car();
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

    public List<Operator> getCars() {
        return operators;
    }
}
