package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    private final static double EPSILON = 1e-8;

    @Test
    void f() {
        Task task = new Task1(-0.5, 2);

        double[][] values = {
                {0.7, 1.0}, // 175
                {1.4, -0.329742792}, // 350
                {3.0, 0.21424295}, // 750
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0, 3, 0.004);

        assertEquals(0.7, x[175], Task.EPSILON);
        assertEquals(1.4, x[350], Task.EPSILON);
        assertEquals(3.0, x[750], Task.EPSILON);

        Task task = new Task1(-0.5, 2);

        assertEquals(1.0, task.f(x[175]), Task.EPSILON);
        assertEquals(-0.329742792, task.f(x[350]), Task.EPSILON);
        assertEquals(0.21424295, task.f(x[750]), Task.EPSILON);

    }


}