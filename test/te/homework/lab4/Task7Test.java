package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task7Test {

    @Test
    void f() {
        Task task = new Task7(1.5);

        double[][] values = {
                {0.1, -0.001135218}, // 0
                {0.3, -0.033055066}, // 200
                {1.0, 1.676091259}, // 900
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.1, 1.0, 0.001);

        assertEquals(0.1, x[0], Task.EPSILON);
        assertEquals(0.3, x[200], Task.EPSILON);
        assertEquals(1.0, x[900], Task.EPSILON);

        Task task = new Task7(1.5);

        assertEquals(-0.001135218, task.f(x[0]), Task.EPSILON);
        assertEquals(-0.033055066, task.f(x[200]), Task.EPSILON);
        assertEquals(1.676091259, task.f(x[900]), Task.EPSILON);
    }
}