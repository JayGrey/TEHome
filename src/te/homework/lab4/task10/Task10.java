package te.homework.lab4.task10;

import te.homework.lab4.Task;

public class Task10 implements Task {

    private final double t;

    Task10(double t) {
        this.t = t;
    }

    @Override
    public double f(double x) {
        if (x <= 0.9) {
            return (Math.pow(Math.log(x), 3) + Math.pow(x, 2)) / Math.sqrt(x + t);
        } else {
            return Math.cos(x) + t * Math.pow(Math.sin(x), 2);
        }
    }
}
