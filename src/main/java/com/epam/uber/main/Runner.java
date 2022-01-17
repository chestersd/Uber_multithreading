package com.epam.uber.main;

import com.epam.uber.entity.*;
import com.epam.uber.util.Parser;
import com.epam.uber.util.ParserException;
import com.epam.uber.util.ParserJSONImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    private static final String PATH = "src/main/java/resources/passengers.json";

    public static void main(String[] args) throws ParserException, ParseException {
        run();
    }

    private static void run() throws ParseException, ParserException {
        Parser parser = new ParserJSONImpl();
        PassengerStore passengers = parser.parse(PATH);
        ExecutorService executorService = Executors.newFixedThreadPool(passengers.getPassengers().size());
        for (Passenger passenger : passengers.getPassengers()) {
            executorService.execute(passenger);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
    }
}
