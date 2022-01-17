package com.epam.uber.service;

import com.epam.uber.entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operator {
    private static final Logger LOGGER = LogManager.getLogger(Operator.class);
    private static Operator instance;
    private final Queue<Car> allCars = new ArrayDeque<>();
    private final Semaphore semaphore = new Semaphore(5);
    private static final Lock LOCK = new ReentrantLock();

    private Operator() {
        initOperator();
    }

    private Car initCar(){
        return new  Car((long)(Math.random() * 1000000));
    }

    private void initOperator() {
        allCars.add(initCar());
        allCars.add(initCar());
        allCars.add(initCar());
    }

    public static Operator getInstance(){
        Operator localInstance = instance;
        if (localInstance == null) {
            LOCK.lock();
            try {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Operator();
                }
            } finally {
                LOCK.unlock();
            }
        }
        return localInstance;
    }

    public Car searchForCar() throws OperatorException {
        LOGGER.info("Searching for a car");
        try {
            semaphore.acquire();
            LOCK.lock();
            return allCars.poll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new OperatorException(e.getMessage(), e.fillInStackTrace());
        } finally {
            LOCK.unlock();
        }
    }

    public void releaseCar(Car car) {
        LOCK.lock();
        try {
            allCars.add(car);
        } finally {
            semaphore.release();
            LOCK.unlock();
        }
    }



}
