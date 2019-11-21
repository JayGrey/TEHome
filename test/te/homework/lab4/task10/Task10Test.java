package te.homework.lab4.task10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task10Test {

    private final static double EPSILON = 1e-8;

    @Test
    void testY10() {
        Task10 task10 = new Task10(2.2);
        double[][] values = new double[][]{
                {0.2, -2.665200955}, // 0
                {0.9, 0.459384803}, // 175
                {2.0, 1.402861146}, // 450
        };

        for (double[] value : values) {
            assertEquals(value[1], task10.f(value[0]), EPSILON);
        }
    }


}