package com.epam.uber.entity;

import com.epam.uber.service.Operator;
import com.epam.uber.service.OperatorException;
import org.apache.logging.log4j.LogManager;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.Logger;

public class Passenger implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);
    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public boolean isNeeded() {
        return isNeeded;
    }

    void changeIsNeeded() {
        isNeeded = true;
    }

    @JsonProperty
    private boolean isNeeded;
    private final Operator operator = Operator.getInstance();

//    public Passenger() {
//    }

    @Override
    public void run() {
        try {
            Car car = operator.searchForCar();
            car.move(this);
            operator.releaseCar(car);
            LOGGER.info("Car is free");
        } catch (OperatorException e) {
            LOGGER.error(e.getMessage(), e.fillInStackTrace());
        }
    }

}
