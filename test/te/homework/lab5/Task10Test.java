package te.homework.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 5.10")
class Task10Test {
    private static double EPSILON = 1e-8;

    @Test
    void calculate() {
        Task task = new Task10();
        assertEquals(2.0, task.calculate(new double[]{1, 2, 3}), EPSILON);
        assertEquals(2.0, task.calculate(new double[]{3, 2, 1}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[]{3, -2, -1}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[]{-33, -2, -1}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[]{3}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[]) null), EPSILON);
    }

    @Test
    void testCalculate() {
        Task task = new Task10();

        double[][] matrix4 = {
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 1, 1, 1},
        };

        assertEquals(0.0, task.calculate(matrix4), EPSILON);

        //
        double[][] matrix5 = {
                {1, 1, 1, 1, 1},
                {0, 6.2, 1, 1, 0},
                {0, 0, 1, 0, 9.7},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 3.3, 1},
        };

        assertEquals(9.5, task.calculate(matrix5), EPSILON);
    }
}