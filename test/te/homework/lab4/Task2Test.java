package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {
    private final static double EPSILON = 1e-8;

    @Test
    void f() {
        Task task = new Task2(1.5);

        double[][] values = {
                {0.8, -9.9775}, // 0
                {1.7, 16.496383367}, // 180
                {2.0, 1.075528529}, // 240
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.8, 2.0, 0.005);

        assertEquals(0.8, x[0], Task.EPSILON);
        assertEquals(1.7, x[180], Task.EPSILON);
        assertEquals(2.0, x[240], Task.EPSILON);

        Task task = new Task2(1.5);

        assertEquals(-9.9775, task.f(x[0]), Task.EPSILON);
        assertEquals(16.496383367, task.f(x[180]), Task.EPSILON);
        assertEquals(1.075528529, task.f(x[240]), Task.EPSILON);

    }
}