package com.epam.uber.entity;

import com.epam.uber.*;

public class Passenger implements Runnable {
    private long id;
    private double xCoordinateOfPassenger;
    private double yCoordinateOfPassenger;

    @Override
    public void run() {
        Car car = Car.getInstance();
        for (Operator operator : car.getCars()) {
            operator.selectCar(this);
        }
    }

    public double calculateDistance(Passenger passenger, Car car){
        double distance;
        double xCoordinateOfCar = car.getxCoordinateOfCar();
        double yCoordinateOfCar = car.getyCoordinateOfCar();
        distance = Math.sqrt((passenger.xCoordinateOfPassenger - xCoordinateOfCar) *
                (passenger.xCoordinateOfPassenger - xCoordinateOfCar) +
                (passenger.yCoordinateOfPassenger - yCoordinateOfCar) *
                        (passenger.yCoordinateOfPassenger * yCoordinateOfCar));
        return distance;
    }

}
