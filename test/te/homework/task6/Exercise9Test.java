package te.homework.task6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise9Test {
    private static final double EPSILON = 1e-8;

    @Test
    void testOnTrashData() {
        assertTrue(Double.isNaN(Exercise9.findK(null, null)));
        assertTrue(Double.isNaN(Exercise9.findK(Collections.emptyList(), null)));
        assertTrue(Double.isNaN(Exercise9.findK(null, Collections.emptyList())));
        assertTrue(Double.isNaN(Exercise9.findK(Collections.emptyList(), Collections.emptyList())));
        assertTrue(Double.isNaN(Exercise9.findK(Arrays.asList(1.0, 2.0),
                Arrays.asList(1.0, 2.0, 3.0))));
    }

    @Test
    void testFirstQuadrant() {
        double[][] data = {
                {1, 2}, {2, 2}, {2, 4},
                {3, 4}, {5, 5}, {3, 6},
                {4, 8}, {7, 10}
        };

        double expected = findK(data);

        assertEquals(expected,
                Exercise9.findK(
                        Arrays.asList(1.0, 2.0, 2.0, 3.0, 5.0, 3.0, 4.0, 7.0),
                        Arrays.asList(2.0, 2.0, 4.0, 4.0, 5.0, 6.0, 8.0, 10.0)
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

        assertEquals(expected,
                Exercise9.findK(
                        Arrays.asList(-2.0, -4.0, -3.0, -5.0, 2.0, 1.0),
                        Arrays.asList(3.0, 3.0, 5.0, 6.0, -1.0, -3.0)
                ),
                EPSILON);
    }

    @Test
    void testOnSinglePoint() {
        assertEquals(1.0, Exercise9.findK(Collections.singletonList(1.0), Collections.singletonList(1.0)), EPSILON);
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
