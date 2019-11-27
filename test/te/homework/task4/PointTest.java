package te.homework.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
        assertEquals(0, Point.of(1, 2).distance(Point.of(1, 2)));
        assertEquals(4, Point.of(1, 1).distance(Point.of(1, 5)));

        try {
            Point.of(1, 2).distance(null);
            fail();
        } catch (IllegalArgumentException ignored) {

        }
    }
}