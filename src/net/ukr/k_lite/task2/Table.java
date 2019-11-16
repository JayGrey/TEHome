package net.ukr.k_lite.task2;


import java.util.stream.DoubleStream;

public interface Table {

    static void print(GenerateStrategy strategy, double from, double to, double step) {

        if (step <= 0.0) {
            throw new RuntimeException("step must be greater than zero");
        }

        if (from > to) {
            throw new RuntimeException("from must be less than to");
        }

        System.out.println("   x   | sin(x)");
        System.out.println("---------------");
        double[] values = strategy.generate(from, to, step);

        double x = from;
        for (int i = 0; i < values.length; i++, x += step) {
            System.out.format("%.04f | %.04f%n", x, values[i]);
        }

        System.out.println("---------------");
        System.out.format("min: %.04f%n", min(values));
        System.out.printf("max: %.04f%n", max(values));

    }

    static double min(double[] values) {
        return DoubleStream.of(values)
                .min()
                .orElseThrow(RuntimeException::new);

    }

    static double max(double[] values) {
        return DoubleStream.of(values)
                .max()
                .orElseThrow(RuntimeException::new);
    }

}
