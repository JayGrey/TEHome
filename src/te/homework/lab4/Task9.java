package te.homework.lab4;

public class Task9 implements Task {
    private final double a;

    Task9(double a) {
        this.a = a;
    }

    @Override
    public double f(double x) {
        if (x <= (1.2 + EPSILON)) {
            return Math.pow(Math.sin(Math.sqrt(a * x)), 2);
        } else {
            return Math.log10(x + 1.0);
        }
    }
}
