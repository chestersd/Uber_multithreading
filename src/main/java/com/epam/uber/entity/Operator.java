package com.epam.uber.entity;

import com.epam.uber.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operator {
    private static final Logger LOGGER = LogManager.getLogger(Operator.class);
    private static final int NUMBER_OF_CARS = 5;

    private final long id;
    private int passengersExpect;
    private final Semaphore carSemaphore = new Semaphore(NUMBER_OF_CARS, true);
    private final Lock carLock = new ReentrantLock();
//    private Location locationOfCarTaxi;

    public Operator(){
        id = IdGenerator.generatorId();
    }

    public void selectCar(){

    }

//    public void


}
