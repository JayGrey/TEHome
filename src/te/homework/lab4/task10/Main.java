package te.homework.lab4.task10;

import te.homework.lab4.Task;

public class Main {


    public static void main(String[] args) {
        final double from = 0.2;
        final double to = 2.0;
        final double step = 0.004;

        Task10 task10 = new Task10(2.2);
        double[] x = Task.getX(from, to, step);
        double[] y = task10.getY(x);

        printMinAndMax(x, y);
    }


    private static void printMinAndMax(double[] x, double[] y) {
        int indexMin = Task.indexOfMinElement(y);
        int indexMax = Task.indexOfMaxElement(y);

        System.out.format("min: i: %d, x: %f, f(x): %f%n", indexMin, x[indexMin], y[indexMin]);
        System.out.format("max: i: %d, x: %f, f(x): %f%n", indexMax, x[indexMax], y[indexMax]);
    }
}
