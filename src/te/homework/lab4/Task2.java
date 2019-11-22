package te.homework.lab4;


public class Task2 implements Task {
    private final double a;

    Task2(double a) {
        this.a = a;
    }

    @Override
    public double f(double x) {
        if (x < 1.7) {
            return a * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        } else if (x > (1.7 + EPSILON)) {
            return Math.log10(x + 7 * Math.sqrt(x));
        } else {
            return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
        }
    }
}
