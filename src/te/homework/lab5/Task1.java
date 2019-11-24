package te.homework.lab5;

import java.util.stream.DoubleStream;

public class Task1 extends Task {

    /*
     * Знайти суму елементів масиву
     * */
    @Override
    public double calculate(double[] array) {
        return array == null ? Double.NaN : DoubleStream.of(array).sum();
    }

    /*
    Знайти суму елементів заштрихованої частини
       1 1 1 1
       1 1 1 0
       1 1 0 0
       1 0 0 0
     */
    @Override
    public double calculate(double[][] array) {
        return array == null
                ? Double.NaN
                : calculate(
                MatrixUtils.cutFigure(0, array.length - 1, 0, array.length - 1, MatrixUtils.Figure.UPPER_LEFT, array));
    }
}
