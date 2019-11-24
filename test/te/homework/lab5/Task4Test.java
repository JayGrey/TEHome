package te.homework.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {
    private final static double EPSILON = 1e-8;

    @Test
    void absSum() {

        Task4 task = new Task4();

        assertEquals(4.0, task.absSum(new double[]{1, 2, -3.0, 4}), EPSILON);
        assertEquals(34.0, task.absSum(new double[]{1, 2, 3.0, -40}), EPSILON);
        assertEquals(0.0, task.absSum(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.absSum(null), EPSILON);
    }

    @Test
    void sqrtProd() {
        Task4 task = new Task4();

        assertEquals(12.0, task.sqrtProd(new double[]{1, 2, 3.0, 4, 6.0}), EPSILON);
        assertEquals(Double.NaN, task.sqrtProd(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.sqrtProd(null), EPSILON);
    }

    @Test
    void calculate() {
        Task task = new Task4();
        double[][] matrix = {
                {1, 2, 0.3, 4},
                {0, 2, 3, 4},
                {0, 0, -0.3, 4},
                {0.01, 0, 0, 4},
        };

        assertEquals(0.3, task.calculate(matrix), EPSILON);

        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[][]) null), EPSILON);
    }
}