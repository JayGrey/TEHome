package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task10Test {


    @Test
    void testY10() {
        Task task10 = new Task10(2.2);
        double[][] values = {
                {0.2, -2.665200955}, // 0
                {0.9, 0.459384803}, // 175
                {2.0, 1.402861146}, // 450
        };

        for (double[] value : values) {
            assertEquals(value[1], task10.f(value[0]), Task.EPSILON);
        }
    }

    @Test
    void testValues() {
        double[] x = Task.getX(0.2, 2.0, 0.004);

        assertEquals(0.2, x[0], Task.EPSILON);
        assertEquals(0.9, x[175], Task.EPSILON);
        assertEquals(2.0, x[450], Task.EPSILON);

        Task task = new Task10(2.2);

        assertEquals(-2.665200955, task.f(x[0]), Task.EPSILON);
        assertEquals(0.459384803, task.f(x[175]), Task.EPSILON);
        assertEquals(1.402861146, task.f(x[450]), Task.EPSILON);
    }
}