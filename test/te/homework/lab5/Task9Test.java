package te.homework.lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 5.9 tests")
class Task9Test {
    private final static double EPSILON = 1e-8;
    private Task9 task;

    @BeforeEach
    void setUp() {
        task = new Task9();
    }

    @Test
    void calculate() {

        assertEquals(4.0, task.calculate(new double[]{1.0, 2.0, 3.0}), EPSILON);
        assertEquals(2.0, task.calculate(new double[]{1.0}), EPSILON);
        assertEquals(Double.NaN, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[]) null), EPSILON);
    }

    @Test
    void rectangleNegativeAverage() {
        double[][] matrix5 = new double[][]{
                {2, -1, -1, -1, 2},
                {1, 1, 0, 1, 1},
                {2, 1, 1, 1, 2},
                {1, 1, 0, 1, 1},
                {2, -2, -2, -2, 2},
        };

        assertEquals(-1.5, task.rectangleNegativeAverage(matrix5), EPSILON);
    }

    @Test
    void butterflyAverage() {
        double[][] matrix5 = new double[][]{
                {2, -1, -1, -1, 2},
                {1, 1, 0, 1, 1},
                {2, 1, 1, 1, 2},
                {1, 1, 0, 1, 1},
                {2, -2, -2, -2, 2},
        };

        assertEquals(1.352941176, task.butterflyAverage(matrix5), EPSILON);
    }

    @Test
    void testCalculate() {

        double[][] matrix5 = new double[][]{
                {2, -1, -1, -1, 2},
                {1, 1, 0, 1, 1},
                {2, 1, 1, 1, 2},
                {1, 1, 0, 1, 1},
                {2, -2, -2, -2, 2},
        };

        assertEquals(-0.073529412, task.calculate(matrix5), EPSILON);

    }
}