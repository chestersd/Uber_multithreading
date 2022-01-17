package com.epam.uber.util;

import com.epam.uber.entity.PassengerStore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParserJSONImpl implements Parser {
    public PassengerStore parse(String filePath) throws ParserException {
        PassengerStore passengers;
        ObjectMapper objectMapper = new ObjectMapper();
        try (JsonParser jsonParser = objectMapper.createParser(new File(filePath))) {
            passengers = jsonParser.readValueAs(PassengerStore.class);
        } catch (IOException e) {
            throw new ParserException(e.getMessage(), e.fillInStackTrace());
        }
        return passengers;
    }
}
