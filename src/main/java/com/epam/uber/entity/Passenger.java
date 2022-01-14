package com.epam.uber.entity;

public class Passenger implements Runnable {
    private long id;
    private Location locationOfPassenger;

    @Override
    public void run() {
        OperatorTaxi operatorTaxi = OperatorTaxi.getInstance();
        for (Car car : operatorTaxi.getCars()) {
            car.exchangePassengers(this);
        }
    }

}
