package te.homework.task2;

public class GenerateWithDoWhileLoop implements GenerateStrategy {
    @Override
    public double[] generate(double from, double to, double step) {
        int tableLength = (int) ((to - from) / step) + 1;
        double[] result = new double[tableLength];

        double x = from;
        int index = 0;

        do {
            result[index] = Math.sin(x);

            x += step;
            index += 1;
        } while (x <= to);

        return result;
    }
}
