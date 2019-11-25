package te.homework.lab5;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static te.homework.lab5.MatrixUtils.Figure.UPPER_LEFT;
import static te.homework.lab5.MatrixUtils.Figure.UPPER_RIGHT;

class Task7 extends Task {

    /*
     Знайти найменше значення серед елементів масиву з парними номерами
    */
    @Override
    public double calculate(double[] array) {
        return array == null ? Double.NaN : IntStream.range(0, array.length)
                .filter(a -> a % 2 == 0)
                .mapToDouble(i -> array[i])
                .min()
                .orElse(Double.NaN);
    }

    /*
       Знайти суму елементів заштрихованої частини, які за модулем менші 100
    */
    @Override
    public double calculate(double[][] array) {
        if (array == null) {
            return Double.NaN;
        }

        int split = array.length / 2;

        DoubleStream upperTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split,
                0, split,
                UPPER_RIGHT, array
        );

        DoubleStream lowerTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                array.length - split, array.length - 1,
                UPPER_LEFT, array
        );

        DoubleSummaryStatistics result = DoubleStream
                .concat(upperTriangle, lowerTriangle)
                .filter(a -> Math.abs(a) < 100.0).summaryStatistics();

        return result.getCount() > 0 ? result.getSum() : Double.NaN;
    }
}
