package te.homework.lab4.task1;

import te.homework.lab4.Task;

public class Task1 implements Task {

    private final double a;
    private final double b;

    Task1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double f(double x) {
        if (x <= 0.7) {
            return 1.0;
        } else if (x > 1.4) {
            return Math.exp(a * x) * Math.cos(b * x);
        } else {
            return a * x * x * Math.log(x);
        }
    }
}
