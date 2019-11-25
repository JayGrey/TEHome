package te.homework.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task7Test {
    private final static double EPSILON = 1e-8;

    @Test
    void calculate() {
        Task task = new Task7();

        assertEquals(-1.0, task.calculate(new double[]{1, -2, -1, 4, 5}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[]) null), EPSILON);
    }

    @Test
    void testCalculate() {
        Task task = new Task7();

        //
        double[][] matrix = new double[][]{
                {1, 1, -150, 1},
                {10, -1, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
        };
        assertEquals(2.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {1, 1, 100.0},
                {1, 1, 1},
                {1, 1, 1},
        };
        assertEquals(3.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {1, 1},
                {1, 1}
        };
        assertEquals(2.0, task.calculate(matrix), EPSILON);
    }
}