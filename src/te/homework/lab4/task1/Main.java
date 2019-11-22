package te.homework.lab4.task1;

import te.homework.lab4.Task;


public class Main {


    public static void main(String[] args) {
        final double from = 0.0;
        final double to = 3.0;
        final double step = 0.004;

        Task task = new Task1(-0.5, 2.0);
        double[] x = Task.getX(from, to, step);
        double[] y = task.getY(x);

        task.printMinAndMax(x, y);
    }


}
