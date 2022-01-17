package com.epam.uber.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PassengerStore {
    @JsonProperty
    private ArrayList<Passenger> passengers;

//    public PassengerStore() {
//    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return ("PassengersStore: " + passengers);
    }
}
