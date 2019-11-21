package net.ukr.k_lite.lab3.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 3 task 2")
class Task2Test {
    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @Test
    void getEnCharPos() {

        assertEquals(1, task2.getCharPos('A'));
        assertEquals(1, task2.getCharPos('a'));

        assertEquals(26, task2.getCharPos('Z'));
        assertEquals(26, task2.getCharPos('z'));

    }

    @Test
    void getRuCharPos() {
        assertEquals(1, task2.getCharPos('А'));
        assertEquals(1, task2.getCharPos('а'));

        assertEquals(32, task2.getCharPos('Я'));
        assertEquals(32, task2.getCharPos('я'));
    }

    @Test
    void getNonAlphaCharPos() {
        assertEquals(0, task2.getCharPos('-'));
    }

    @Test
    void getCharsPos() {
        int[] expected = {1, 2, 3, 4};

        assertArrayEquals(expected, task2.getCharsPos("abcd"));
        assertArrayEquals(expected, task2.getCharsPos("ABCD"));
        assertArrayEquals(expected, task2.getCharsPos("абвг"));
        assertArrayEquals(expected, task2.getCharsPos("АБВГ"));
    }
}