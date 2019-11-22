package te.homework.lab4;

public class Task8 implements Task {
    @Override
    public double f(double x) {
        if (x <= (3.4 + EPSILON)) {
            return Math.pow(Math.cos(x), 2);
        } else {
            return Math.sin(x) * Math.log10(x);
        }
    }
}
