package te.homework.task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise9Test {
    private static final double EPSILON = 1e-8;

    @Test
    void testOnTrashData() {
        assertTrue(Double.isNaN(Exercise9.findK(null, null)));
        assertTrue(Double.isNaN(Exercise9.findK(new double[0], null)));
        assertTrue(Double.isNaN(Exercise9.findK(null, new double[0])));
        assertTrue(Double.isNaN(Exercise9.findK(new double[0], new double[0])));
        assertTrue(Double.isNaN(Exercise9.findK(new double[]{1, 2}, new double[]{1, 2, 3})));
    }

    @Test
    void testFirstQuadrant() {
        double[][] data = {
                {1, 2}, {2, 2}, {2, 4},
                {3, 4}, {5, 5}, {3, 6},
                {4, 8}, {7, 10}
        };

        double expected = findK(data);
        System.out.println(expected);


        assertEquals(expected,
                Exercise9.findK(
                        new double[]{1, 2, 2, 3, 5, 3, 4, 7},
                        new double[]{2, 2, 4, 4, 5, 6, 8, 10}
                ),
                EPSILON);
    }

    @Test
    void testSecondQuadrant() {
        double[][] data = {
                {-2, 3}, {-4, 3}, {-3, 5},
                {-5, 6}, {2, -1}, {1, -3}
        };

        double expected = findK(data);
        System.out.println(expected);

        assertEquals(expected,
                Exercise9.findK(
                        new double[]{-2, -4, -3, -5, 2, 1},
                        new double[]{3, 3, 5, 6, -1, -3}
                ),
                EPSILON);
    }

    @Test
    void testOnSinglePoint() {
        assertEquals(1.0, Exercise9.findK(new double[]{1}, new double[]{1}), EPSILON);
    }

    private double findK(double[][] values) {
        // sum(x * y) / sum(x^2)
        double sumN = 0;
        double sumD = 0;

        for (double[] point : values) {
            sumN += (point[0] * point[1]);
            sumD += (point[0] * point[0]);
        }

        return sumN / sumD;
    }
}
