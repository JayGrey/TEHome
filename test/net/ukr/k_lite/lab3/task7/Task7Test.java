package net.ukr.k_lite.lab3.task7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab 3 task 7")
class Task7Test {

    private Task7 task;

    @BeforeEach
    void setUp() {
        task = new Task7();
    }

    @Test
    void replace() {
        assertEquals("abcd defgh ab bcx", task.replace('x', 3, "axbcd dxexfgxh ab bcx"));
    }

    @Test
    void replaceWithOtherDelimiters() {
        Task7 task7 = new Task7(new char[]{' ', '.', ' '});
        assertEquals("abcd defgh,ab.bcx", task7.replace('x', 3, "axbcd dxexfgxh,ab.bcx"));
    }
}