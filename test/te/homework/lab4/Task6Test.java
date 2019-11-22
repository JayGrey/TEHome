package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {

    @Test
    void f() {
        Task task = new Task6(2.4);

        double[][] values = {
                {1.0, -0.066894849}, // 0
                {2.4, -1.199140519}, // 140
                {5.0, 8.062257748}, // 400
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(1.0, 5.0, 0.01);

        assertEquals(1.0, x[0], Task.EPSILON);
        assertEquals(2.4, x[140], Task.EPSILON);
        assertEquals(5.0, x[400], Task.EPSILON);

        Task task = new Task6(2.4);

        assertEquals(-0.066894849, task.f(x[0]), Task.EPSILON);
        assertEquals(-1.199140519, task.f(x[140]), Task.EPSILON);
        assertEquals(8.062257748, task.f(x[400]), Task.EPSILON);
    }
}