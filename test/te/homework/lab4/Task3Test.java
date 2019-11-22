package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {

    @Test
    void f() {
        double[][] values = {
                {0.0, 4.0}, // 0
                {1.4, 3.720465053}, // 700
                {2.0, 0.98386991}, // 1000
        };
        Task task = new Task3(2.8, -0.3, 4);

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.0, 2.0, 0.002);

        assertEquals(0.0, x[0], Task.EPSILON);
        assertEquals(1.4, x[700], Task.EPSILON);
        assertEquals(2.0, x[1000], Task.EPSILON);

        Task task = new Task3(2.8, -0.3, 4.0);

        assertEquals(4.0, task.f(x[0]), Task.EPSILON);
        assertEquals(3.720465053, task.f(x[700]), Task.EPSILON);
        assertEquals(0.98386991, task.f(x[1000]), Task.EPSILON);
    }
}