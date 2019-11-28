package te.homework.task4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findMinBySquare() {
        List<Triangle> list = Arrays.asList(
                new Triangle(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7))
        );

        Triangle expected = new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle notExpected = new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Main.findTriangleWithMinSquare(list));
        assertNotEquals(notExpected, Main.findTriangleWithMinSquare(list));

        try {
            Main.findTriangleWithMinSquare(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Main.findTriangleWithMinSquare(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void findMaxBySquare() {
        List<Triangle> list = Arrays.asList(
                new Triangle(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7)),
                new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4))
        );

        Triangle notExpected = new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle expected = new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Main.findTriangleWithMaxSquare(list));
        assertNotEquals(notExpected, Main.findTriangleWithMaxSquare(list));

        try {
            Main.findTriangleWithMaxSquare(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Main.findTriangleWithMaxSquare(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void findMinByPerimeter() {
        List<Triangle> list = Arrays.asList(
                new Triangle(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7))
        );

        Triangle expected = new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle notExpected = new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Main.findTriangleWithMinPerimeter(list));
        assertNotEquals(notExpected, Main.findTriangleWithMinPerimeter(list));

        try {
            Main.findTriangleWithMinPerimeter(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Main.findTriangleWithMinPerimeter(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void findMaxByPerimeter() {
        List<Triangle> list = Arrays.asList(
                new Triangle(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7)),
                new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4))
        );

        Triangle notExpected = new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle expected = new Triangle(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Main.findTriangleWithMaxPerimeter(list));
        assertNotEquals(notExpected, Main.findTriangleWithMaxPerimeter(list));

        try {
            Main.findTriangleWithMaxPerimeter(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Main.findTriangleWithMaxPerimeter(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void sortByType() {
        Map<Triangle.Type, List<Triangle>> map = Main.sortByType(
                Arrays.asList(
                        new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                        new Triangle(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)))
        );

        assertEquals(1, map.size());
        assertEquals(2, map.get(Triangle.Type.RIGHT).size());

        //
        map = Main.sortByType(
                Arrays.asList(
                        new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                        new Triangle(Point.of(14, 1), Point.of(17, 1), Point.of(14, 4)))
        );

        assertEquals(2, map.size());
        assertEquals(2, map.get(Triangle.Type.RIGHT).size());
        assertEquals(1, map.get(Triangle.Type.ISOSCELES).size());

        //
        try {
            Main.sortByType(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        //
        map = Main.sortByType(Collections.emptyList());
        assertEquals(0, map.size());

        //
        map = Main.sortByType(Arrays.asList(
                new Triangle(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423)),
                new Triangle(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                new Triangle(Point.of(5, 2), Point.of(7, 2), Point.of(6, 6))
        ));
    }
}