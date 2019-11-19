package net.ukr.k_lite.lab4task10;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    private final double t;

    public Main(double t) {
        this.t = t;
    }

    public static void main(String[] args) {
        double t = 2.2;
        double from = 0.2;
        double to = 2.0;
        double step = 0.004;

        Main main = new Main(t);
        double[] x = main.getX(from, to, step);
        double[] y = main.getY(from, to, step);

        main.printMinAndMax(x, y);
    }

    public double f(double x) {

        if (x <= 0.9) {
            return (Math.pow(Math.log(x), 3) + Math.pow(x, 2)) / Math.sqrt(x + t);
        } else {
            return Math.cos(x) + t * Math.pow(Math.sin(x), 2);
        }
    }

    public int getNumberOfSteps(double from, double to, double step) {
        return (int) Math.round((to - from) / step + 1);
    }

    public double[] getX(double from, double to, double step) {
        double[] result = new double[getNumberOfSteps(from, to, step)];

        double x = from;

        for (int i = 0; i < result.length; i++) {
            result[i] = x;
            x += step;
        }
        return result;
    }

    public double[] getY(double from, double to, double step) {
        return getY(getX(from, to, step));
    }

    public double[] getY(double[] x) {
        return DoubleStream.of(x).map(this::f).toArray();
    }

    public int indexOfMaxElement(double[] arr) {
        return IntStream.range(0, arr.length)
                .reduce((i, j) -> arr[i] > arr[j] ? i : j)
                .orElse(-1);
    }

    public int indexOfMinElement(double[] arr) {
        return IntStream.range(0, arr.length)
                .reduce((i, j) -> arr[i] < arr[j] ? i : j)
                .orElse(-1);
    }

    public double sum(double[] arr) {
        return DoubleStream.of(arr).reduce((a, b) -> a + b).orElse(0);
    }

    public double average(double[] arr) {
        return sum(arr) / arr.length;
    }

    public void printMinAndMax(double[] x, double[] y) {
        int indexMin = indexOfMinElement(y);
        int indexMax = indexOfMaxElement(y);

        System.out.format("min: i: %d, x: %f, f(x): %f%n", indexMin, x[indexMin], y[indexMin]);
        System.out.format("max: i: %d, x: %f, f(x): %f%n", indexMax, x[indexMax], y[indexMax]);
    }
}
