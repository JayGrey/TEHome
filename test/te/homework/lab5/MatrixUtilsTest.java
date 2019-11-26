package te.homework.lab5;

import org.junit.jupiter.api.Test;

import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static te.homework.lab5.MatrixUtils.Figure.*;

class MatrixUtilsTest {
    private final static double EPSILON = 1e-8;

    private final double[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    // UL

    @Test
    void cutFigureUpperLeft() {
        double[] expected = {1, 2, 3, 4, 5, 7};
        double[] actual = MatrixUtils.cutFigure(0, 2, 0, 2, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureUpperLeft2() {
        double[] expected = {1, 2, 4};
        double[] actual = MatrixUtils.cutFigure(0, 1, 0, 1, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{2, 3, 5};
        actual = MatrixUtils.cutFigure(0, 1, 1, 2, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{4, 5, 7};
        actual = MatrixUtils.cutFigure(1, 2, 0, 1, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{5, 6, 8};
        actual = MatrixUtils.cutFigure(1, 2, 1, 2, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureUpperLeftSingleElement() {
        double[] expected = {5};
        double[] actual = MatrixUtils.cutFigure(1, 1, 1, 1, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    // UR
    @Test
    void cutFigureUpperRight() {
        double[] expected = {1, 2, 3, 5, 6, 9};
        double[] actual = MatrixUtils.cutFigure(0, 2, 0, 2, UPPER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureUpperRight2() {
        double[] expected = {1, 2, 5};
        double[] actual = MatrixUtils.cutFigure(0, 1, 0, 1, UPPER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{2, 3, 6};
        actual = MatrixUtils.cutFigure(0, 1, 1, 2, UPPER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{4, 5, 8};
        actual = MatrixUtils.cutFigure(1, 2, 0, 1, UPPER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{5, 6, 9};
        actual = MatrixUtils.cutFigure(1, 2, 1, 2, UPPER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    // LR
    @Test
    void cutFigureLowerRight() {
        double[] expected = {3, 5, 6, 7, 8, 9};
        double[] actual = MatrixUtils.cutFigure(0, 2, 0, 2, LOWER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureLowerRight2() {
        double[] expected = {2, 4, 5};
        double[] actual = MatrixUtils.cutFigure(0, 1, 0, 1, LOWER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{3, 5, 6};
        actual = MatrixUtils.cutFigure(0, 1, 1, 2, LOWER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{5, 7, 8};
        actual = MatrixUtils.cutFigure(1, 2, 0, 1, LOWER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{6, 8, 9};
        actual = MatrixUtils.cutFigure(1, 2, 1, 2, LOWER_RIGHT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureLowerRightSingleElement() {
        double[] expected = {5};
        double[] actual = MatrixUtils.cutFigure(1, 1, 1, 1, UPPER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }


    // LL
    @Test
    void cutFigureLowerLeft() {
        double[] expected = {1, 4, 5, 7, 8, 9};
        double[] actual = MatrixUtils.cutFigure(0, 2, 0, 2, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureLowerLeft2() {
        double[] expected = {1, 4, 5};
        double[] actual = MatrixUtils.cutFigure(0, 1, 0, 1, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{2, 5, 6};
        actual = MatrixUtils.cutFigure(0, 1, 1, 2, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{4, 7, 8};
        actual = MatrixUtils.cutFigure(1, 2, 0, 1, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);

        expected = new double[]{5, 8, 9};
        actual = MatrixUtils.cutFigure(1, 2, 1, 2, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    @Test
    void cutFigureLowerLeftSingleElement() {
        double[] expected = {5};
        double[] actual = MatrixUtils.cutFigure(1, 1, 1, 1, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual, EPSILON);
    }

    // Rectangle
    @Test
    void cutFigureRectangleElement() {
        double[] expected = {6, 10};
        double[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        assertArrayEquals(expected, MatrixUtils.cutFigure(1, 2, 1, 1, RECTANGLE, matrix), EPSILON);

    }

    @Test
    void testOutOfBoundaries() {
        double[] actual = MatrixUtils.cutFigure(1, 3, 1, 3, LOWER_LEFT, matrix);
        assertArrayEquals(new double[0], actual, EPSILON);
    }

    @Test
    void cutFigureAndReturnStream() {
        double[] expected = new double[]{5, 8, 9};
        DoubleStream actual = MatrixUtils.cutFigureAndReturnStream(1, 2, 1, 2, LOWER_LEFT, matrix);
        assertArrayEquals(expected, actual.toArray(), EPSILON);

        actual = MatrixUtils.cutFigureAndReturnStream(1, 2, 1, 2, LOWER_LEFT, null);
        assertEquals(0, actual.count());

        actual = MatrixUtils.cutFigureAndReturnStream(1, 2, 1, 2, LOWER_LEFT, new double[0][]);
        assertEquals(0, actual.count());
    }
}