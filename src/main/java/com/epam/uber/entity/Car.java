package com.epam.uber.entity;

public class Car {
    private final long carId;

    public void move(Passenger passenger) {
        passenger.changeIsNeeded();
    }
    public Car(long carId) {
        this.carId = carId;
    }

    public long getCarId() {
        return carId;
    }
}
