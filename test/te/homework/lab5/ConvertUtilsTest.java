package te.homework.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertUtilsTest {
    private static final double EPSILON = 1e-8;

    @Test
    void doubleArrayToString() {
        assertEquals("1.0 2.0 3.0", ConvertUtils.doubleArrayToString(new double[]{1, 2, 3}));
        assertEquals("1.0 2.0 3.0", ConvertUtils.doubleArrayToString(new double[]{1.0, 2.0, 3.0}));
        assertEquals("1.0 -2.0 3.0", ConvertUtils.doubleArrayToString(new double[]{1, -2, 3}));
        assertEquals("1.0 -2.0 0.3", ConvertUtils.doubleArrayToString(new double[]{1, -2, 0.3}));
        assertEquals("", ConvertUtils.doubleArrayToString(new double[]{}));
        assertEquals("", ConvertUtils.doubleArrayToString(null));
    }

    @Test
    void stringToDoubleArray() {
        assertArrayEquals(new double[0], ConvertUtils.StringToDoubleArray(""));
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, ConvertUtils.StringToDoubleArray("1.0 2.0 3.0"),
                EPSILON);

        assertArrayEquals(new double[]{1.0, -2.0, 3.0}, ConvertUtils.StringToDoubleArray("1.0 -2.0 3.0"),
                EPSILON);

        assertArrayEquals(new double[]{1.0, -2.0, 0.3}, ConvertUtils.StringToDoubleArray("1.0 -2.0 0.3"),
                EPSILON);

        assertEquals(0, ConvertUtils.StringToDoubleArray(null).length);
    }
}