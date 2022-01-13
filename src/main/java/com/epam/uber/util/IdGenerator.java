package com.epam.uber.util;

public class IdGenerator {
    private static long counter;

    public static long generatorId() {
        return ++counter;
    }
}
