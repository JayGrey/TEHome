package te.homework.lab4;

public class Task6 implements Task {
    private final double a;

    Task6(double a) {
        this.a = a;
    }

    @Override
    public double f(double x) {
        if (x < a) {
            return Math.pow(Math.E, -a * x) * Math.cos(a * x);
        } else if (x > (a + EPSILON)) {
            return x * Math.sqrt(x - a);
        } else {
            return x * Math.sin(a * x);
        }
    }
}
