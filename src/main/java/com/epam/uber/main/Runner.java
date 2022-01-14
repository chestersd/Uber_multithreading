package com.epam.uber.main;

import com.epam.uber.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        String jsonPath = "src/main/java/resources/passengers.json";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PassengerWrapper passengerWrapper = objectMapper.readValue(new File(jsonPath), PassengerWrapper.class);
            List<Passenger> passengers = passengerWrapper.getPassenger();

            ExecutorService executorService = Executors.newFixedThreadPool(passengers.size());
            passengers.forEach(passenger -> executorService.submit(new Thread(passenger)));
            executorService.shutdown();
        } catch (IOException e) {
            LOGGER.error("IOException caught.", e);
        }
    }
}
