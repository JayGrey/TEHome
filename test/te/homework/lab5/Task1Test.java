package te.homework.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("lab 5.1 tests")
class Task1Test {
    public static final double EPSILON = 1e-8;

    @Test
    void calculateVector() {
        ArrayProcessor processor = new Task1();

        assertEquals(15.0, processor.calculate(new double[]{1, 2, 3, 4, 5}), EPSILON);

        assertEquals(0.0, processor.calculate(new double[0]), EPSILON);

        assertEquals(Double.NaN, processor.calculate((double[]) null), EPSILON);
    }

    @Test
    void testCalculateMatrix() {
        ArrayProcessor processor = new Task1();
        double[][] matrix = {
                {1.00, 2.00, 3.00, 4.00},
                {5.00, 6.00, 7.00, 8.00},
                {9.00, 10.0, 11.0, 12.0},
                {13.0, 14.0, 15.0, 16.0},
        };

        assertEquals(60.00, processor.calculate(matrix), EPSILON);

        assertEquals(1.0, processor.calculate(new double[][]{{1}}), EPSILON);

    }

    @Test
    void testCalculateMatrixNull() {
        ArrayProcessor processor = new Task1();

        assertEquals(Double.NaN, processor.calculate((double[][]) null), EPSILON);
    }
}