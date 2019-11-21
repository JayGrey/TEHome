package te.homework.lab4.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    private final static double EPSILON = 1e-8;

    @Test
    void f() {
        Task1 task = new Task1(-0.5, 2);

        double[][] values = {
                {0.7, 1.0}, // 175
                {1.4, -0.329742792}, // 350
                {3.0, 0.21424295}, // 750
        };

        for (double[] value : values) {
            assertEquals(value[1], task.f(value[0]), EPSILON);
        }
    }
}