package te.homework.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private static final double EPSILON = 1e-8;


    @Test
    void test() {
        Point point = Point.of(1, 2);

        assertEquals(1, point.x);
        assertEquals(2, point.y);
    }

    @Test
    void testNonNumberArguments() {
        try {
            Point.of(1, Double.NaN);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Point.of(Double.NaN, 1);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Point.of(Double.NaN, Double.NaN);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void testDistance() {
        assertEquals(0, Point.of(1, 2).distance(Point.of(1, 2)), EPSILON);
        assertEquals(4, Point.of(1, 1).distance(Point.of(1, 5)), EPSILON);

        try {
            Point.of(1, 2).distance(null);
            fail();
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    void equals() {
        assertEquals(Point.of(1, 0), Point.of(1, 0));
        assertEquals(Point.of(1, 1e-9), Point.of(1, 2e-9));

        assertNotEquals(Point.of(1, 0), Point.of(1, 1));
        assertNotEquals(Point.of(1, 1e-7), Point.of(1, 2e-7));

        assertNotEquals(Point.of(1, 1).hashCode(), Point.of(1.1, 1).hashCode());
    }
}