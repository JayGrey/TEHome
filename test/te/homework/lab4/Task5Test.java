package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @Test
    void f() {
        Task task = new Task5(2.3);

        double[][] values = {
                {0.3, 3.148703936}, // 50
                {2.3, 13.89}, // 1050
                {2.8, -2.453155838}, // 1300
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.2, 2.8, 0.002);

        assertEquals(0.3, x[50], Task.EPSILON);
        assertEquals(2.3, x[1050], Task.EPSILON);
        assertEquals(2.8, x[1300], Task.EPSILON);

        Task task = new Task5(2.3);

        assertEquals(3.148703936, task.f(x[50]), Task.EPSILON);
        assertEquals(13.89, task.f(x[1050]), Task.EPSILON);
        assertEquals(-2.453155838, task.f(x[1300]), Task.EPSILON);
    }
}