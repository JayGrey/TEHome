package te.homework.lab4.task10;

import te.homework.lab4.Task;


public class Main {


    public static void main(String[] args) {
        final double from = 0.2;
        final double to = 2.0;
        final double step = 0.004;

        Task task10 = new Task10(2.2);
        double[] x = Task.getX(from, to, step);
        double[] y = task10.getY(x);

        task10.printMinAndMax(x, y);
    }


}
