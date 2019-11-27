package te.homework.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(Triangle.Type.RIGHT, triangle1.type);

        Triangle triangle2 = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4));
        assertEquals(Triangle.Type.ISOSCELES, triangle2.type);

        Triangle triangle3 = new Triangle(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423));
        assertEquals(Triangle.Type.EQUILATERAL, triangle3.type);

        Triangle triangle4 = new Triangle(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0));
        assertEquals(Triangle.Type.ARBITRARY, triangle4.type);

    }

   /* @Test
    void isEquilateral() {
        Triangle triangle = new Triangle(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423));
        assertTrue(triangle.isEquilateral());

        Triangle triangle1 = new Triangle(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0));
        assertFalse(triangle1.isEquilateral());

    }

    @Test
    void isIsosceles() {
        Triangle triangle1 = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4));
        assertTrue(triangle1.isIsosceles());

        Triangle triangle2 = new Triangle(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0));
        assertFalse(triangle2.isIsosceles());
    }

    @Test
    void isRight() {
        Triangle triangle1 = new Triangle(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));
        assertTrue(triangle1.isRight());

        Triangle triangle2 = new Triangle(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0));
        assertFalse(triangle2.isRight());
    }*/

}