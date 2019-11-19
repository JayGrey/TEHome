package net.ukr.k_lite.lab4task10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main(2.2);
    }

    @Test
    void testUpperLimit() {
        double expected = 1.402861;

        assertEquals(expected, main.f(2), 1e-6);
    }

    @Test
    void testLowerLimit() {
        double expected = -2.665201;
        assertEquals(expected, main.f(0.2), 1e-6);
    }

    @Test
    void testSteps() {
        int expected = 11;
        assertEquals(expected, main.getNumberOfSteps(0, 1, 0.1));
    }

    @Test
    void xValues() {
        double from = 0.2;
        double to = 2.0;
        double step = 0.004;
        double epsilon = 1e-6;

        double[] x = main.getX(from, to, step);
        assertEquals(x.length, main.getNumberOfSteps(from, to, step));
        assertEquals(from, x[0], epsilon);
        assertEquals(to, x[x.length - 1], epsilon);
    }

    @Test
    void yValues() {
        double from = 0.2;
        double to = 2.0;
        double step = 0.004;
        double epsilon = 1e-6;

        double[] y = main.getY(from, to, step);
        assertEquals(y.length, main.getNumberOfSteps(from, to, step));
        assertEquals(y[0], -2.665201, epsilon);
        assertEquals(y[y.length - 1], 1.402861, epsilon);
    }

    @Test
    void indexOfMaxIndex() {
        int expected = 2;
        int actual = main.indexOfMaxElement(new double[]{0.1, -2, 10.12, 3});

        assertEquals(expected, actual);
    }

    @Test
    void indexOfMinIndex() {
        int expected = 1;
        int actual = main.indexOfMinElement(new double[]{0.1, -2, 10.12, 3});

        assertEquals(expected, actual);
    }

    @Test
    void sum() {
        double expected = 10.5;
        double epsilon = 1e-6;

        double actual = main.sum(new double[]{0.1, 0.4, 15.0, -5});

        assertEquals(expected, actual, epsilon);
    }

    @Test
    void average() {
        double expected = 3;
        double epsilon = 1e-6;

        double actual = main.average(new double[]{1, 2, 3, 4, 5});
        assertEquals(expected, actual, epsilon);

    }

}