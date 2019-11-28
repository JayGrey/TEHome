package te.homework.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private static final double EPSILON = 1e-8;

    @Test
    void getSquare() {
        Triangle triangle = new Triangle(Point.of(1, 2), Point.of(5, 2), Point.of(1, 6));
        assertEquals(8, triangle.square, EPSILON);

        Triangle triangle2 = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));
        assertEquals(6, triangle2.square, EPSILON);

        Triangle triangle3 = new Triangle(Point.of(1, 1), Point.of(1, 1), Point.of(1, 1));
        assertEquals(0, triangle3.square, EPSILON);
        Triangle triangle4 = new Triangle(Point.of(6, 1), Point.of(6, 3), Point.of(6, 5));
        assertEquals(0, triangle4.square, EPSILON);
    }

    @Test
    void getPerimeter() {
        Triangle triangle = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));

        assertEquals(12, triangle.perimeter, EPSILON);

        Triangle triangle2 = new Triangle(Point.of(1, 1), Point.of(1, 1), Point.of(1, 1));
        assertEquals(0, triangle2.perimeter, EPSILON);

        Triangle triangle3 = new Triangle(Point.of(6, 1), Point.of(6, 3), Point.of(6, 5));
        assertEquals(8, triangle3.perimeter, EPSILON);
    }

    @Test
    void getType() {
        Triangle triangle1 = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));
        assertEquals(1, triangle1.type.size());
        assertTrue(triangle1.type.contains(Triangle.Type.RIGHT));

        Triangle triangle2 = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4));
        assertEquals(2, triangle2.type.size());
        assertTrue(triangle2.type.contains(Triangle.Type.RIGHT));
        assertTrue(triangle2.type.contains(Triangle.Type.ISOSCELES));


        Triangle triangle3 = new Triangle(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423));
        assertEquals(2, triangle3.type.size());
        assertTrue(triangle3.type.contains(Triangle.Type.EQUILATERAL));
        assertTrue(triangle3.type.contains(Triangle.Type.ISOSCELES));


        Triangle triangle4 = new Triangle(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0));
        assertEquals(1, triangle4.type.size());
        assertTrue(triangle4.type.contains(Triangle.Type.ARBITRARY));

        Triangle triangle5 = new Triangle(Point.of(5, 2), Point.of(7, 2), Point.of(6, 6));
        assertEquals(1, triangle5.type.size());
        assertTrue(triangle5.type.contains(Triangle.Type.ISOSCELES));

    }

    @Test
    void equals() {
        Triangle triangle1 = new Triangle(Point.of(1, 2), Point.of(3, 4), Point.of(3, 1));
        Triangle triangle2 = new Triangle(Point.of(2, 2), Point.of(3, 4), Point.of(3, 1));
        Triangle triangle3 = new Triangle(Point.of(1 + 2e-9, 2), Point.of(3, 4), Point.of(3, 1));

        assertNotEquals(triangle1, triangle2);
        assertEquals(triangle1, triangle3);

    }

}