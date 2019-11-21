package te.homework.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    private final static double EPSILON = 1e-8;

    @Test
    void testSteps() {
        int expected = 11;
        assertEquals(expected, Task.getNumberOfSteps(0, 1, 0.1));
    }

    @Test
    void xValues() {
        double from = 0.2;
        double to = 2.0;
        double step = 0.004;

        double[] x = Task.getX(from, to, step);
        assertEquals(x.length, Task.getNumberOfSteps(from, to, step));
        assertEquals(from, x[0], EPSILON);
        assertEquals(to, x[x.length - 1], EPSILON);
    }

    @Test
    void indexOfMaxIndex() {
        int expected = 2;
        int actual = Task.indexOfMaxElement(new double[]{0.1, -2, 10.12, 3});

        assertEquals(expected, actual);
    }

    @Test
    void indexOfMinIndex() {
        int expected = 1;
        int actual = Task.indexOfMinElement(new double[]{0.1, -2, 10.12, 3});

        assertEquals(expected, actual);
    }

    @Test
    void sum() {
        double expected = 10.5;

        double actual = Task.sum(new double[]{0.1, 0.4, 15.0, -5});

        assertEquals(expected, actual, EPSILON);
    }

    @Test
    void average() {
        double expected = 3;

        double actual = Task.average(new double[]{1, 2, 3, 4, 5});
        assertEquals(expected, actual, EPSILON);

    }

}