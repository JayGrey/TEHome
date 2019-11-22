package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8Test {

    @Test
    void f() {
        Task task = new Task8();

        double[][] values = {
                {2.0, 0.17317819}, // 0
                {3.4, 0.934698745}, // 280
                {5.0, -0.670259304}, // 600
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(2.0, 5.0, 0.005);

        assertEquals(2.0, x[0], Task.EPSILON);
        assertEquals(3.4, x[280], Task.EPSILON);
        assertEquals(5.0, x[600], Task.EPSILON);

        Task task = new Task8();

        assertEquals(0.17317819, task.f(x[0]), Task.EPSILON);
        assertEquals(0.934698745, task.f(x[280]), Task.EPSILON);
        assertEquals(-0.670259304, task.f(x[600]), Task.EPSILON);
    }
}