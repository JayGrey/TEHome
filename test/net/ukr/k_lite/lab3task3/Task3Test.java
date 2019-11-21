package net.ukr.k_lite.lab3task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 3 task 3")
class Task3Test {

    private Task3 task3;

    @BeforeEach
    void setUp() {
        task3 = new Task3();
    }

    @Test
    void changeSubstring() {
        String[][] testData = {
                {"aaaffafРа badfdadf", "aaaffafРо badfdadf"},
                {"aaaffafРА badfdadf", "aaaffafРО badfdadf"},
                {"aaaffafра badfdadf", "aaaffafро badfdadf"},
                {"aaaffafрА badfdadf", "aaaffafрО badfdadf"},
                {"рАaaaffaf badfdadf", "рОaaaffaf badfdadf"},
                {"aaaрАffaf badfdadf", "aaaрОffaf badfdadf"},
                {"abcd deer dfdf", "abcd deer dfdf"},
                {"abcd dрбr dfdf", "abcd dрбr dfdf"},
        };

        for (String[] strings : testData) {
            assertEquals(strings[1], task3.changeSubstring(strings[0]));
        }
    }
}