package te.homework.lab5;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.collectingAndThen;
import static te.homework.lab5.MatrixUtils.Figure.*;

public class Task10 extends Task {

    // Знайти різницю першого та останнього додатних елементів масиву
    @Override
    public double calculate(double[] array) {
        return array == null ? Double.NaN : Arrays.stream(array)
                .filter(a -> a > 0)
                .boxed()
                .collect(collectingAndThen(Collectors.toList(),
                        l -> l.size() < 2 ? Double.NaN :
                                Math.abs(l.get(0) - l.get(l.size() - 1))));
    }

    // Знайти суму елементів заштрихованої частини, ціла частина яких кратна 3
    @Override
    public double calculate(double[][] array) {
        if (array == null) {
            return Double.NaN;
        }

        int split = array.length / 2;

        DoubleStream upperRightTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                0, split - 1,
                UPPER_RIGHT, array
        );

        DoubleStream upperLeftTriangle = MatrixUtils.cutFigureAndReturnStream(
                0, split - 1,
                array.length - split, array.length - 1,
                UPPER_LEFT, array
        );

        DoubleStream lowerRightTriangle = MatrixUtils.cutFigureAndReturnStream(
                array.length - split, array.length - 1,
                0, split - 1,
                LOWER_RIGHT, array
        );

        DoubleStream lowerLeftTriangle = MatrixUtils.cutFigureAndReturnStream(
                array.length - split, array.length - 1,
                array.length - split, array.length - 1,
                LOWER_LEFT, array
        );

        DoubleStream rectangle = array.length % 2 == 0 ? DoubleStream.empty() : MatrixUtils.cutFigureAndReturnStream(
                0, array.length - 1,
                split, split,
                RECTANGLE, array
        );
        return DoubleStream.concat(
                DoubleStream.concat(
                        DoubleStream.concat(upperRightTriangle, upperLeftTriangle),
                        DoubleStream.concat(lowerRightTriangle, lowerLeftTriangle))
                , rectangle)
                .filter(d -> Math.round(d) % 3 == 0)
                .sum();

    }
}
