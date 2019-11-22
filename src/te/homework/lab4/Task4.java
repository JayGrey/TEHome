package te.homework.lab4;

public class Task4 implements Task {

    private final double a;

    Task4(double a) {
        this.a = a;
    }

    @Override
    public double f(double x) {
        if ((x + EPSILON) < (1.3)) {
            return a * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        } else if ((x) > (1.3 + EPSILON)) {
            return Math.log(x + 7 * Math.sqrt(Math.abs(x + a)));
        } else {
            return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
        }
    }
}
