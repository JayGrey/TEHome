package te.homework.lab5;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

import static te.homework.lab5.MatrixUtils.Figure.*;

public class Task9 extends Task {

    /* Знайти суму найбільшого та найменшого елементів масиву */
    @Override
    public double calculate(double[] array) {
        if (array == null) {
            return Double.NaN;
        }

        DoubleSummaryStatistics stats = Arrays.stream(array)
                .summaryStatistics();

        return stats.getMax() + stats.getMin();
    }


    double rectangleNegativeAverage(double[][] array) {
        return MatrixUtils.cutFigureAndReturnStream(
                0, array.length - 1,
                0, array.length - 1,
                RECTANGLE, array
        ).filter(a -> a < 0).average().orElse(Double.NaN);
    }

    double butterflyAverage(double[][] array) {
        int split = array.length / 2;

        DoubleStream lowerLeftTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                0, split - 1,
                LOWER_LEFT, array
        );

        DoubleStream lowerRightTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                array.length - split, array.length - 1,
                LOWER_RIGHT, array
        );

        DoubleStream upperLeftTriangle = MatrixUtils.cutFigureAndReturnStream(
                array.length - split, array.length - 1,
                0, split - 1,
                UPPER_LEFT, array
        );

        DoubleStream upperRightTriangle = MatrixUtils.cutFigureAndReturnStream(
                array.length - split, array.length - 1,
                array.length - split, array.length - 1,
                UPPER_RIGHT, array
        );

        DoubleStream rectangle = array.length % 2 == 0 ? DoubleStream.empty()
                : MatrixUtils.cutFigureAndReturnStream(
                split, split,
                0, array.length - 1,
                RECTANGLE, array);

        return DoubleStream.concat(
                DoubleStream.concat(
                        DoubleStream.concat(lowerLeftTriangle, lowerRightTriangle),
                        DoubleStream.concat(upperLeftTriangle, upperRightTriangle)
                ), rectangle).average().orElse(Double.NaN);
    }

    /*
       Знайти середнє арифметичне від’ємних елементів та заштрихованої частини
   */

    @Override
    public double calculate(double[][] array) {
        double element1 = rectangleNegativeAverage(array);
        double element2 = butterflyAverage(array);

        return Double.isNaN(element1) || Double.isNaN(element2)
                ? Double.NaN
                : (element1 + element2) / 2;
    }
}
