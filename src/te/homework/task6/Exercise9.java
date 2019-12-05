package te.homework.task6;

/*
    Списки (стеки, очереди) I(1..n) и U(1..n) содержат результаты n-измерений тока и напряжения
    на неизвестном сопротивлении R.

    Найт приблеженное число R методом наименьших квадратов.
*/

import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

abstract class Exercise9 {
    private static final double DELTA = 1e-16;

    private Exercise9() {

    }

    static double findK(double[] x, double[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0 || x.length != y.length) {
            return Double.NaN;
        }

        double kMin, kMax;
        kMin = kMax = y[0] / x[0];

        for (int i = 1; i < x.length; i++) {
            double kTemp = y[i] / x[i];
            kMin = Math.min(kMin, kTemp);
            kMax = Math.max(kMax, kTemp);
        }

        return process(x, y, kMin, kMax);
    }

    private static double epsilon(double[] x, double[] y, UnaryOperator<Double> func) {
        return IntStream
                .range(0, x.length)
                .mapToDouble(i -> (y[i] - func.apply(x[i])) * (y[i] - func.apply(x[i])))
                .sum();
    }

    private static double process(double[] x, double[] y, double kMin, double kMax) {
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
