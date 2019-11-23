package te.homework.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    private static final double EPSILON = 1e-8;

    @Test
    void doubleArrayToString() {
        assertEquals("1.0 2.0 3.0", Utils.doubleArrayToString(new double[]{1, 2, 3}));
        assertEquals("1.0 2.0 3.0", Utils.doubleArrayToString(new double[]{1.0, 2.0, 3.0}));
        assertEquals("1.0 -2.0 3.0", Utils.doubleArrayToString(new double[]{1, -2, 3}));
        assertEquals("1.0 -2.0 0.3", Utils.doubleArrayToString(new double[]{1, -2, 0.3}));
        assertEquals("", Utils.doubleArrayToString(new double[]{}));
    }

    @Test
    void stringToDoubleArray() {
        assertArrayEquals(new double[0], Utils.StringToDoubleArray(""));
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, Utils.StringToDoubleArray("1.0 2.0 3.0"),
                EPSILON);

        assertArrayEquals(new double[]{1.0, -2.0, 3.0}, Utils.StringToDoubleArray("1.0 -2.0 3.0"),
                EPSILON);

        assertArrayEquals(new double[]{1.0, -2.0, 0.3}, Utils.StringToDoubleArray("1.0 -2.0 0.3"),
                EPSILON);
    }
}