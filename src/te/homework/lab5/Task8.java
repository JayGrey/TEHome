package te.homework.lab5;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static te.homework.lab5.MatrixUtils.Figure.*;

public class Task8 extends Task {

    /* Знайти найбільший елемент масиву з непарним номером */
    @Override
    public double calculate(double[] array) {
        if (array == null) {
            return Double.NaN;
        }

        DoubleSummaryStatistics stats = IntStream.range(0, array.length)
                .filter(i -> i % 2 != 0)
                .mapToDouble(i -> array[i])
                .summaryStatistics();

        return stats.getCount() > 0 ? stats.getMax() : Double.NaN;

    }

    /*
       Знайти значення найбільшого від’ємного елемента заштрихованої частини
    */
    @Override
    public double calculate(double[][] array) {
        if (array == null || array.length == 0) {
            return Double.NaN;
        }

        final int split = array.length / 2;

        DoubleStream leftTriangle = MatrixUtils.cutFigureAndReturnStream(
                array.length - split, array.length - 1,
                0, split - 1,
                LOWER_RIGHT, array
        );

        DoubleStream rightTriangle = MatrixUtils.cutFigureAndReturnStream(
                array.length - split, array.length - 1,
                array.length - split, array.length - 1,
                LOWER_LEFT, array
        );

        DoubleStream rectangle = array.length % 2 == 0 ? DoubleStream.empty() :
                MatrixUtils.cutFigureAndReturnStream(
                        array.length - split - 1, array.length - 1,
                        split, split,
                        RECTANGLE, array
                );

        return DoubleStream.concat(DoubleStream.concat(leftTriangle, rightTriangle), rectangle)
                .filter(a -> a < 0)
                .max()
                .orElse(Double.NaN);
    }
}
