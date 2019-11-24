package te.homework.lab5;

import java.util.Arrays;

import static te.homework.lab5.MatrixUtils.Figure.LOWER_LEFT;

public class Task3 extends Task {

    /*
     * Знайти суму квадратів елементів масиву
     */
    @Override
    public double calculate(double[] array) {
        return array == null ? Double.NaN : Arrays.stream(array).map(a -> a * a).sum();
    }

    @Override
    public double calculate(double[][] array) {

        return array == null ? Double.NaN : MatrixUtils
                .cutFigureAndReturnStream(0, array.length - 1, 0, array[0].length - 1,
                        LOWER_LEFT, array)
                .filter(a -> a > 0.0).sum();
    }
}
