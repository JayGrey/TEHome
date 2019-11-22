package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    @Test
    void f() {
        Task task = new Task4(1.65);
        double[][] values = {
                {0.7, -13.477214286}, // 0
                {1.3, 11.606277976}, // 120
                {2.0, 2.732644027}, // 260
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.7, 2.0, 0.005);

        assertEquals(0.7, x[0], Task.EPSILON);
        assertEquals(1.3, x[120], Task.EPSILON);
        assertEquals(2.0, x[260], Task.EPSILON);

        Task task = new Task4(1.65);

        assertEquals(-13.477214286, task.f(x[0]), Task.EPSILON);
        assertEquals(11.606277976, task.f(x[120]), Task.EPSILON);
        assertEquals(2.732644027, task.f(x[260]), Task.EPSILON);
    }
}