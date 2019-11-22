package te.homework.lab4;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public interface Task {

    static int getNumberOfSteps(double from, double to, double step) {
        return (int) Math.round((to - from) / step + 1);
    }

    static double[] getX(double from, double to, double step) {
        double[] result = new double[getNumberOfSteps(from, to, step)];

        for (int i = 0; i < result.length; i++) {
            result[i] = from + step * i;
        }
        return result;
    }

    static int indexOfMaxElement(double[] arr) {
        return IntStream.range(0, arr.length)
                .reduce((i, j) -> arr[i] > arr[j] ? i : j)
                .orElse(-1);
    }

    static int indexOfMinElement(double[] arr) {
        return IntStream.range(0, arr.length)
                .reduce((i, j) -> arr[i] < arr[j] ? i : j)
                .orElse(-1);
    }

    static double sum(double[] arr) {
        return DoubleStream.of(arr).reduce((a, b) -> a + b).orElse(0);
    }

    static double average(double[] arr) {
        return sum(arr) / arr.length;
    }

    default double[] getY(double[] x) {
        return DoubleStream.of(x).map(this::f).toArray();
    }

    default void printMinAndMax(double[] x, double[] y) {
        int indexMin = indexOfMinElement(y);
        int indexMax = indexOfMaxElement(y);

        System.out.format("min: i: %d, x: %f, f(x): %f%n", indexMin, x[indexMin], y[indexMin]);
        System.out.format("max: i: %d, x: %f, f(x): %f%n", indexMax, x[indexMax], y[indexMax]);
    }

    double f(double x);
}
