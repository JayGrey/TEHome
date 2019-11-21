package net.ukr.k_lite.lab3task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    private Task1 task1;

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @Test
    void replace1() {
        String expected = "Hallo warld !";

        assertEquals(expected, task1.replace(2, 'a', "Hello world !"));
    }

    @Test
    void replace2() {
        String expected = "abc def ghi";

        assertEquals(expected, task1.replace(4, 'a', "abc def ghi"));
    }

    @Test
    void replace3() {
        Task1 task1 = new Task1(new char[]{','});

        String expected = "a2c,d2f,g2i";

        assertEquals(expected, task1.replace(2, '2', "abc,def,ghi"));
    }
}