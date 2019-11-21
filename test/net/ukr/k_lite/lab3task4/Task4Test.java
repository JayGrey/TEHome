package net.ukr.k_lite.lab3task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 3 task 4")
class Task4Test {

    private Task4 task4;

    @BeforeEach
    void setUp() {
        task4 = new Task4();
    }

    @Test
    void changeWord() {
        final int EXPECTED_INDEX = 0;
        final int ACTUAL_INDEX = 1;

        String[][] data = {
                {"a bb 1234 dddd 1234 ffffff", "a bb ccc dddd eee ffffff"},
                {"a bb 1234 dddd 1234 ", "a bb ccc dddd eee "},
                {"a bb cccc dddd ee", "a bb cccc dddd ee"},
                {"", ""},
        };

        for (String[] strings : data) {
            assertEquals(strings[EXPECTED_INDEX], task4.changeWord("1234", 3, strings[ACTUAL_INDEX]));
        }
    }

    @Test
    void changeWordWithDifferentSeparator() {
        Task4 task4 = new Task4(new char[] {',', '.', ' '});

        final int EXPECTED_INDEX = 0;
        final int ACTUAL_INDEX = 1;

        String[][] data = {
                {"a,bb.1234 dddd 1234 ffffff", "a,bb.ccc dddd eee ffffff"},
                {"", ""},
        };

        for (String[] strings : data) {
            assertEquals(strings[EXPECTED_INDEX], task4.changeWord("1234", 3, strings[ACTUAL_INDEX]));
        }
    }
}