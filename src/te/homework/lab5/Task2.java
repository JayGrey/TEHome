package te.homework.lab5;

import java.util.Arrays;

public class Task2 extends Task {
    /*
    Знайти добуток елементів масиву
    */
    @Override
    public double calculate(double[] array) {
        return array == null ? Double.NaN :
                Arrays.stream(array).reduce((a, b) -> a * b).orElse(Double.NaN);
    }

    @Override
    public double calculate(double[][] array) {
        return array == null ? Double.NaN
                : MatrixUtils.cutFigureAndReturnStream(0,
                array.length - 1, 0,
                array[0].length - 1,
                MatrixUtils.Figure.LOWER_RIGHT, array).max().orElse(Double.NaN);
    }
}
