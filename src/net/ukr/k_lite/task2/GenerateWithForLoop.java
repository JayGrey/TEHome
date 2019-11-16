package net.ukr.k_lite.task2;

public class GenerateWithForLoop implements GenerateStrategy {
    @Override
    public double[] generate(double from, double to, double step) {
        int tableLength = (int) ((to - from) / step) + 1;
        double[] result = new double[tableLength];

        double x = from;
        for (int index = 0; x <= to; index++, x += step) {
            result[index] = Math.sin(x);
        }

        return result;
    }
}
