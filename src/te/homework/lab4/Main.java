package te.homework.lab4;


public class Main {
    public static void main(String[] args) {

        double[][] range = {
                {0.0, 3.0, 0.004},
                {0.8, 2.0, 0.005},
                {0.0, 2.0, 0.002},
                {0.7, 2.0, 0.005},
                {0.2, 2.8, 0.002},
                {1.0, 5.0, 0.01},
                {0.1, 1.0, 0.001},
                {2.0, 5.0, 0.005},
                {0.2, 2.0, 0.004},
        };

        Task[] functions = {
                new Task1(-0.5, 2),
                new Task2(1.5), // todo: where is p param ?
                new Task3(2.8, -0.3, 4.0),
                new Task4(1.65), // todo: where is p param ?
                new Task5(2.3),
                new Task6(2.4),
                new Task7(1.5),
                new Task8(),
                new Task10(2.2),
        };

        for (int i = 0; i < functions.length; i++) {
            double[] x = Task.getX(range[i][0], range[i][1], range[i][2]);
            double[] y = functions[i].getY(x);

            System.out.println();
            functions[i].printMinAndMax(x, y);
        }
    }
}
