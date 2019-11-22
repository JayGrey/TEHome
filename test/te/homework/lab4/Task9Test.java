package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task9Test {

    @Test
    void f() {
        Task task = new Task9(20.3);

        double[][] values = {
                {0.5, 0.001962429}, // 0
                {1.2, 0.951005257}, // 140
                {2.0, 0.477121255}, // 300
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.5, 2.0, 0.005);

        assertEquals(0.5, x[0], Task.EPSILON);
        assertEquals(1.2, x[140], Task.EPSILON);
        assertEquals(2.0, x[300], Task.EPSILON);

        Task task = new Task9(20.3);

        assertEquals(0.001962429, task.f(x[0]), Task.EPSILON);
        assertEquals(0.951005257, task.f(x[140]), Task.EPSILON);
        assertEquals(0.477121255, task.f(x[300]), Task.EPSILON);
    }
}