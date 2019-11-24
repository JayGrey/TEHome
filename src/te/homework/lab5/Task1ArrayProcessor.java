package te.homework.lab5;

import java.util.stream.DoubleStream;

public class Task1ArrayProcessor implements ArrayProcessor {

    /*
     * Знайти суму елементів масиву
     * */
    @Override
    public double calculate(double[] array) {
        return array == null ? 0.0 : DoubleStream.of(array).sum();
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
                ? 0.0
                : calculate(
                MatrixUtils.cutFigure(0, array.length - 1, 0, array.length - 1, MatrixUtils.Figure.UPPER_LEFT, array));
    }

    @Override
    public void processArray(double[] array) {
        // ???
    }

    @Override
    public void processArray(double[][] array) {
        // ???
    }
}
