package te.homework.lab4;

public class Task3 implements Task {
    private final double a;
    private final double b;
    private final double c;

    Task3(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double f(double x) {
        if (x < 1.4) {
            return a * Math.pow(x, 2) + b * x + c;
        } else if (x > (1.4 + EPSILON)) {
            return (a + b * x) / Math.sqrt(Math.pow(x, 2) + 1);
        } else {
            return a / x + Math.sqrt(Math.pow(x, 2) + 1);
        }
    }
}
