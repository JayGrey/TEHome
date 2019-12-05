package te.homework.task6;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

abstract class Exercise9 {
    private static final double DELTA = 1e-16;

    private Exercise9() {

    }

    static double findK(List<Double> x, List<Double> y) {
        if (x == null || y == null || y.size() == 0 || x.size() != y.size()) {
            return Double.NaN;
        }

        double kMin, kMax;
        kMin = kMax = y.get(0) / x.get(0);

        for (int i = 1; i < x.size(); i++) {
            double kTemp = y.get(i) / x.get(i);
            kMin = Math.min(kMin, kTemp);
            kMax = Math.max(kMax, kTemp);
        }

        return process(x, y, kMin, kMax);
    }

    private static double epsilon(List<Double> x, List<Double> y, UnaryOperator<Double> func) {
        return IntStream
                .range(0, x.size())
                .mapToDouble(i -> Math.pow(y.get(i) - func.apply(x.get(i)), 2))
                .sum();
    }

    private static double process(List<Double> x, List<Double> y, double kMin, double kMax) {
        double kMid = (kMax + kMin) / 2;

        double eMax = epsilon(x, y, a -> kMax * a);
        double eMin = epsilon(x, y, a -> kMin * a);
        double eMid = epsilon(x, y, a -> kMid * a);

        double delta1 = Math.abs(eMax - eMid);
        double delta2 = Math.abs(eMin - eMid);

        if (Math.abs(delta1 - delta2) <= DELTA) {
            return kMid;
        }

        return delta1 < delta2 ? process(x, y, kMid, kMax) : process(x, y, kMin, kMid);

    }
}
