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
                Triangle.of(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7))
        );

        Triangle expected = Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle notExpected = Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Triangles.findTriangleWithMinSquare(list));
        assertNotEquals(notExpected, Triangles.findTriangleWithMinSquare(list));

        try {
            Triangles.findTriangleWithMinSquare(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Triangles.findTriangleWithMinSquare(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void findMaxBySquare() {
        List<Triangle> list = Arrays.asList(
                Triangle.of(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7)),
                Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4))
        );

        Triangle notExpected = Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle expected = Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Triangles.findTriangleWithMaxSquare(list));
        assertNotEquals(notExpected, Triangles.findTriangleWithMaxSquare(list));

        try {
            Triangles.findTriangleWithMaxSquare(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Triangles.findTriangleWithMaxSquare(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void findMinByPerimeter() {
        List<Triangle> list = Arrays.asList(
                Triangle.of(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7))
        );

        Triangle expected = Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle notExpected = Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Triangles.findTriangleWithMinPerimeter(list));
        assertNotEquals(notExpected, Triangles.findTriangleWithMinPerimeter(list));

        try {
            Triangles.findTriangleWithMinPerimeter(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Triangles.findTriangleWithMinPerimeter(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void findMaxByPerimeter() {
        List<Triangle> list = Arrays.asList(
                Triangle.of(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)),
                Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7)),
                Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4))
        );

        Triangle notExpected = Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4));
        Triangle expected = Triangle.of(Point.of(9, 1), Point.of(13, 1), Point.of(9, 7));

        assertEquals(expected, Triangles.findTriangleWithMaxPerimeter(list));
        assertNotEquals(notExpected, Triangles.findTriangleWithMaxPerimeter(list));

        try {
            Triangles.findTriangleWithMaxPerimeter(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Triangles.findTriangleWithMaxPerimeter(Collections.emptyList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void sortByType() {
        Map<Triangle.Type, List<Triangle>> map = Triangles.sortByType(
                Arrays.asList(
                        Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                        Triangle.of(Point.of(4, 1), Point.of(7, 1), Point.of(4, 5)))
        );

        assertEquals(1, map.size());
        assertEquals(2, map.get(Triangle.Type.RIGHT).size());

        //
        map = Triangles.sortByType(
                Arrays.asList(
                        Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)),
                        Triangle.of(Point.of(14, 1), Point.of(17, 1), Point.of(14, 4)))
        );

        assertEquals(2, map.size());
        assertEquals(2, map.get(Triangle.Type.RIGHT).size());
        assertEquals(1, map.get(Triangle.Type.ISOSCELES).size());

        //
        try {
            Triangles.sortByType(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        //
        map = Triangles.sortByType(Collections.emptyList());
        assertEquals(0, map.size());

        //
        map = Triangles.sortByType(Arrays.asList(
                Triangle.of(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423)), // equa
                Triangle.of(Point.of(1, 1), Point.of(3, 1), Point.of(1, 4)), //right
                Triangle.of(Point.of(5, 2), Point.of(7, 2), Point.of(6, 6)),  // iso
                Triangle.of(Point.of(9, 1), Point.of(12, 1), Point.of(11, 4)), // ar
                Triangle.of(Point.of(14, 1), Point.of(17, 1), Point.of(14, 4)) // right iso
        ));

        assertEquals(4, map.size());
        assertEquals(1, map.get(Triangle.Type.EQUILATERAL).size());
        assertEquals(2, map.get(Triangle.Type.RIGHT).size());
        assertEquals(3, map.get(Triangle.Type.ISOSCELES).size());
        assertEquals(1, map.get(Triangle.Type.ARBITRARY).size());

    }
}