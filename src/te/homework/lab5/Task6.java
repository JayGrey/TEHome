package te.homework.lab5;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

import static te.homework.lab5.MatrixUtils.Figure.LOWER_RIGHT;
import static te.homework.lab5.MatrixUtils.Figure.UPPER_RIGHT;

class Task6 extends Task {

    /*
     * Знайти найменше значення серед елементів масиву
     */
    @Override
    public double calculate(double[] array) {
        return array == null ? Double.NaN : Arrays.stream(array).min().orElse(Double.NaN);
    }

    /*
      Знайти значення найбільшого від’ємного елемента заштрихованої частини
    */
    @Override
    public double calculate(double[][] array) {
        if (array == null) {
            return Double.NaN;
        }

        int split = array.length / 2;

        DoubleStream upperTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                array.length - split, array.length - 1,
                LOWER_RIGHT, array
        );

        DoubleStream lowerTriangle = MatrixUtils.cutFigureAndReturnStream(
                split, array.length - 1,
                split, array.length - 1,
                UPPER_RIGHT, array
        );

        DoubleSummaryStatistics result = DoubleStream
                .concat(upperTriangle, lowerTriangle)
                .filter(a -> a < 0.0).summaryStatistics();

        return result.getCount() > 0 ? result.getMax() : Double.NaN;
    }
}
