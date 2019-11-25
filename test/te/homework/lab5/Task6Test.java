package te.homework.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {
    private final static double EPSILON = 1e-8;

    @Test
    void calculate() {
        Task task = new Task6();

        assertEquals(-2, task.calculate(new double[]{-1, -2, 2, 3, 5}), EPSILON);
        assertEquals(1, task.calculate(new double[]{1, 1, 1, 1}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[]) null), EPSILON);

    }

    @Test
    void testCalculate() {

        Task task = new Task6();

        //
        double[][] matrix = new double[][]{
                {-1, -1, -3},
                {-1, -2, -1},
                {-1, -0.1, -4},
        };
        assertEquals(-1.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {-4, -3},
                {-1, -2},
        };
        assertEquals(-2.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {-3.0},
        };
        assertEquals(-3.0, task.calculate(matrix), EPSILON);

        //
        matrix = new double[][]{
                {3.0},
        };
        assertEquals(Double.NaN, task.calculate(matrix), EPSILON);

        assertEquals(Double.NaN, task.calculate(new double[][]{}), EPSILON);

        assertEquals(Double.NaN, task.calculate((double[][]) null), EPSILON);


    }
}