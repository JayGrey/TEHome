package te.homework.lab5;

import java.util.Arrays;

public class Task2ArrayProcessor implements ArrayProcessor {
    @Override
    public double calculate(double[] array) {
        return array == null || array.length == 0 ? 0.0 :
                Arrays.stream(array).reduce((a, b) -> a * b).orElse(0.0);
    }

    @Override
    public double calculate(double[][] array) {
        return array == null ? Double.NEGATIVE_INFINITY
                : MatrixUtils.cutFigureAndReturnStream(0,
                array.length - 1, 0,
                array[0].length - 1,
                MatrixUtils.Figure.LOWER_RIGHT, array).max().orElse(Double.NEGATIVE_INFINITY);
    }

    @Override
    public void processArray(double[] array) {

    }

    @Override
    public void processArray(double[][] array) {

    }
}
