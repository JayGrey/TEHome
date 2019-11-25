package te.homework.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {
    private final static double EPSILON = 1e-8;

    @Test
    void calculate() {
        Task task = new Task5();
        assertEquals(1.0, task.calculate(new double[]{1.0, -1.0, 0}), EPSILON);
        assertEquals(1.0, task.calculate(new double[]{-1.0, 1.0, 0}), EPSILON);
        assertEquals(0.1, task.calculate(new double[]{-1.0, 0.0, 0.1}), EPSILON);
        assertEquals(1.0, task.calculate(new double[]{1.0}), EPSILON);

        assertEquals(Double.NaN, task.calculate(new double[]{-1.0, -2, -3}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[]) null), EPSILON);
    }

    @Test
    void testCalculate() {
        Task task = new Task5();

        //
        double[][] matrix = new double[][]{
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1},
        };
        assertEquals(-4.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {-1, -1},
                {-1, -1},
        };
        assertEquals(-2.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {-1},
        };
        assertEquals(-1.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {1},
        };
        assertEquals(Double.NaN, task.calculate(matrix), EPSILON);

        //
        assertEquals(Double.NaN, task.calculate((double[][]) null), EPSILON);
    }
}