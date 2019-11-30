package te.homework.task4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private static final double EPSILON = 1e-8;

    @Test
    void of() {
        try {
            Triangle.of(null, Point.of(1, 1), Point.of(2, 2));
            fail();
        } catch (IllegalArgumentException ignored) {

        }

        try {
            Triangle.of(Point.of(1, 1), null, Point.of(2, 2));
            fail();
        } catch (IllegalArgumentException ignored) {

        }

        try {
            Triangle.of(Point.of(1, 1), Point.of(2, 2), null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

    }

    @Test
    void getSquare() {
        Triangle triangle = Triangle.of(Point.of(1, 2), Point.of(5, 2), Point.of(1, 6));
        assertEquals(8, triangle.square, EPSILON);

        Triangle triangle2 = Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));
        assertEquals(6, triangle2.square, EPSILON);

        Triangle triangle3 = Triangle.of(Point.of(1, 1), Point.of(1, 1), Point.of(1, 1));
        assertEquals(0, triangle3.square, EPSILON);
        Triangle triangle4 = Triangle.of(Point.of(6, 1), Point.of(6, 3), Point.of(6, 5));
        assertEquals(0, triangle4.square, EPSILON);
    }

    @Test
    void getPerimeter() {
        Triangle triangle = Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));

        assertEquals(12, triangle.perimeter, EPSILON);

        Triangle triangle2 = Triangle.of(Point.of(1, 1), Point.of(1, 1), Point.of(1, 1));
        assertEquals(0, triangle2.perimeter, EPSILON);

        Triangle triangle3 = Triangle.of(Point.of(6, 1), Point.of(6, 3), Point.of(6, 5));
        assertEquals(8, triangle3.perimeter, EPSILON);
    }

    @Test
    void getType() {
        Triangle triangle1 = Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 5));
        assertEquals(1, triangle1.type.size());
        assertTrue(triangle1.type.contains(Triangle.Type.RIGHT));

        Triangle triangle2 = Triangle.of(Point.of(1, 1), Point.of(4, 1), Point.of(1, 4));
        assertEquals(2, triangle2.type.size());
        assertTrue(triangle2.type.contains(Triangle.Type.RIGHT));
        assertTrue(triangle2.type.contains(Triangle.Type.ISOSCELES));


        Triangle triangle3 = Triangle.of(Point.of(1, 1), Point.of(7, 1), Point.of(4, 6.196152423));
        assertEquals(2, triangle3.type.size());
        assertTrue(triangle3.type.contains(Triangle.Type.EQUILATERAL));
        assertTrue(triangle3.type.contains(Triangle.Type.ISOSCELES));


        Triangle triangle4 = Triangle.of(Point.of(0, 0), Point.of(1, 2), Point.of(3, 0));
        assertEquals(1, triangle4.type.size());
        assertTrue(triangle4.type.contains(Triangle.Type.ARBITRARY));

        Triangle triangle5 = Triangle.of(Point.of(5, 2), Point.of(7, 2), Point.of(6, 6));
        assertEquals(1, triangle5.type.size());
        assertTrue(triangle5.type.contains(Triangle.Type.ISOSCELES));

    }

    @Test
    void equals() {
        Triangle triangle1 = Triangle.of(Point.of(1, 2), Point.of(3, 4), Point.of(3, 1));
        Triangle triangle2 = Triangle.of(Point.of(2, 2), Point.of(3, 4), Point.of(3, 1));
        Triangle triangle3 = Triangle.of(Point.of(1 + 2e-9, 2), Point.of(3, 4), Point.of(3, 1));

        assertNotEquals(triangle1, triangle2);
        assertEquals(triangle1, triangle3);

    }

    @Test
    void typeModify() {
        Triangle triangle = Triangle.of(Point.of(14, 1), Point.of(17, 1), Point.of(14, 4));
        assertEquals(2, triangle.type.size());
        try {
            triangle.type.add(Triangle.Type.ARBITRARY);
            fail();
        } catch (UnsupportedOperationException ignored) {

        }
    }

    @Test
    void loadFrom(@TempDir Path tempDir) {
        Path file = tempDir.resolve("triangles.txt");
        prepareFile(file, new String[]{
                " 1 2 5.0 2 -11 6.45",
        });
        List<Triangle> triangles = Triangles.loadFrom(file.toString());
        assertEquals(1, triangles.size());
        assertEquals(Point.of(1, 2), triangles.get(0).a);
        assertEquals(Point.of(5, 2), triangles.get(0).b);
        assertEquals(Point.of(-11, 6.45), triangles.get(0).c);
    }

    @Test
    void loadFromMultiplyLines(@TempDir Path tempDir) {
        Path file = tempDir.resolve("triangles.txt");
        prepareFile(file, new String[]{
                " 1 2 5.0 2 -11 6.45",
                " 1 2 5.0 2 -11 6.45",
                " 1 2 5.0 2 -11 6.45",
                "ada da a",
                " 1 2 5.0 2 -11",
                "",
                "1 2 5.0   2   -11 7.12",
                ""

        });
        List<Triangle> triangles = Triangles.loadFrom(file.toString());
        assertEquals(4, triangles.size());
    }

    @Test
    void loadFromNonExistingFile() {
        List<Triangle> triangles = Triangles.loadFrom("non existing file");
        assertEquals(0, triangles.size());
    }

    private void prepareFile(Path filename, String[] lines) {
        try {
            Files.write(filename, Arrays.asList(lines));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}