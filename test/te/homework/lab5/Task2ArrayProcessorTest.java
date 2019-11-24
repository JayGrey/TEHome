package te.homework.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 5.2 tests")
class Task2ArrayProcessorTest {
    private static final double EPSILON = 1e-8;

    @Test
    void calculate() {
        ArrayProcessor processor = new Task2ArrayProcessor();
        assertEquals(24.0, processor.calculate(new double[]{1.0, 2.0, 3.0, 4.0}), EPSILON);
        assertEquals(-1.0, processor.calculate(new double[]{1.0, -1.0}), EPSILON);
        assertEquals(0.0, processor.calculate(new double[0]), EPSILON);
        assertEquals(0.0, processor.calculate((double[]) null), EPSILON);
    }

    @Test
    void testCalculate() {
        double[][] matrix = {
                {0.0, 0.0, 0.0, 1.0},
                {0.0, 0.0, 2.0, 0.0},
                {0.0, 5.0, 3.0, 0.0},
                {0.2, 9.0, 0.4, 0.0},
        };
        ArrayProcessor processor = new Task2ArrayProcessor();

        assertEquals(9.0, processor.calculate(matrix), EPSILON);
        assertEquals(Double.NEGATIVE_INFINITY, processor.calculate((double[][]) null), EPSILON);
    }
}