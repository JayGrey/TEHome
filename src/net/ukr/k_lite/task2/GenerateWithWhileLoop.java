package net.ukr.k_lite.task2;

public class GenerateWithWhileLoop implements GenerateStrategy {
    @Override
    public double[] generate(double from, double to, double step) {
        int tableLength = (int) ((to - from) / step) + 1;
        double[] result = new double[tableLength];
        double x = from;
        int index = 0;

        while (x <= to) {
            result[index] = Math.sin(x);

            x += step;
            index += 1;
        }
        return result;
    }
}
