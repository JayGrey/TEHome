package te.homework.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 5.8 tests")
class Task8Test {
    private final static double EPSILON = 1e-8;

    @Test
    void calculate() {
        Task task = new Task8();
        assertEquals(2, task.calculate(new double[]{0, 2, -1, -2}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[]) null), EPSILON);
    }

    @Test
    void testCalculate() {
        Task task = new Task8();

        double[][] matrix4 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, -0.005, 0},
                {-1, 1, 1, 1},
        };

        assertEquals(-0.005, task.calculate(matrix4), EPSILON);

        //

        double[][] matrix5 = {
                {11, 12, 13, 14, 15},
                {21, 22, 23, 24, 25},
                {31, 32, -33, -10, 35},
                {41, 42, 43, 44, 45},
                {-51, 52, 53, 54, 55},
        };

        assertEquals(-33, task.calculate(matrix5), EPSILON);

        //

        double[][] matrix2 = {
                {-1, -0.1},
                {1, -2},
        };

        assertEquals(-2, task.calculate(matrix2), EPSILON);

        //
        assertEquals(-1, task.calculate(new double[][]{{-1}}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[][]{{1}}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0][]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[][]) null), EPSILON);

    }
}