package te.homework.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 5.3 tests")
class Task3Test {
    private static final double EPSILON = 1e-8;

    @Test
    void calculate() {
        Task processor = new Task3();

        assertEquals(30.0, processor.calculate(new double[]{1, 2, 3, 4}));
        assertEquals(0.0, processor.calculate(new double[0]));
        assertEquals(Double.NaN, processor.calculate((double[]) null));
    }

    @Test
    void testCalculate() {
        Task task = new Task3();

        double[][] matrix = {
                {-1, 2, 3},
                {1, 2, 3},
                {0, -2, 3},
        };

        assertEquals(6.0, task.calculate(matrix), EPSILON);

        assertEquals(0.0, task.calculate(new double[0]), EPSILON);
        assertEquals(Double.NaN, task.calculate((double[][]) null), EPSILON);
    }
}