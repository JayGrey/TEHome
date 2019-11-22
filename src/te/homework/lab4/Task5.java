package te.homework.lab4;

public class Task5 implements Task {

    private final double a;


    Task5(double a) {
        this.a = a;
    }

    @Override
    public double f(double x) {
        if (x <= (0.3 + EPSILON)) {
            return 1.5 * a * Math.pow(Math.cos(x), 2);
        } else if (x > (2.3 + EPSILON)) {
            return 3 * a * Math.tan(x);
        } else {
            return Math.pow(x - 2, 2) + 6 * a;
        }
    }
}
