package te.homework.lab4;

public class Task7 implements Task {
    private final double b;

    Task7(double b) {
        this.b = b;
    }

    @Override
    public double f(double x) {
        if (b * x <= (0.45 + EPSILON)) {
            return b * x - Math.tan(b * x);
        } else {
            return b * x + Math.log10(b * x);
        }
    }
}
