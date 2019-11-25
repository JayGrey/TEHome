package te.homework.lab5;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

import static te.homework.lab5.MatrixUtils.Figure.LOWER_LEFT;
import static te.homework.lab5.MatrixUtils.Figure.UPPER_LEFT;

public class Task5 extends Task {

    /*
     * Знайти останній додатний елемент масиву.
     * */
    @Override
    public double calculate(double[] array) {
        if (array != null) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] > 0) {
                    return array[i];
                }
            }
        }

        return Double.NaN;
    }

    /*
     * Знайти суму від’ємних елементів заштрихованої частини
     */
    @Override
    public double calculate(double[][] array) {
        if (array == null) {
            return Double.NaN;
        }

        int split = array.length / 2;

        DoubleStream upperTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                0, split - 1,
                LOWER_LEFT, array
        );

        DoubleStream lowerTriangle = MatrixUtils.cutFigureAndReturnStream(
                split, array.length - 1,
                0, array.length - split - 1,
                UPPER_LEFT, array
        );

        DoubleSummaryStatistics result = DoubleStream
                .concat(upperTriangle, lowerTriangle)
                .filter(a -> a < 0.0).summaryStatistics();

        return result.getCount() > 0 ? result.getSum() : Double.NaN;
    }
}
