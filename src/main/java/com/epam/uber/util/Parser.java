package com.epam.uber.util;

import com.epam.uber.entity.PassengerStore;

public interface Parser {
    PassengerStore parse(String filePath) throws ParserException;
}
