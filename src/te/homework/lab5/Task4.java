package te.homework.lab5;

import java.util.Arrays;

import static te.homework.lab5.MatrixUtils.Figure.UPPER_RIGHT;

public class Task4 extends Task {
    // Знайти модуль суми та квадратний корінь добутку елементів масиву
    @Override
    public double calculate(double[] array) {
        return Double.NaN;
    }

    /*
    Знайти значення найменшого
    додатного елемента заштрихованої
    частини
    * */
    @Override
    public double calculate(double[][] array) {
        return array == null ? Double.NaN : MatrixUtils.cutFigureAndReturnStream(
                0, array.length - 1,
                0, array[0].length - 1,
                UPPER_RIGHT, array).filter(a -> a > 0).min().orElse(Double.NaN);
    }

    double absSum(double[] array) {
        return array == null ? Double.NaN : Math.abs(Arrays.stream(array).sum());
    }

    double sqrtProd(double[] array) {
        return array == null ? Double.NaN :
                Math.sqrt(Arrays.stream(array).reduce((a, b) -> a * b).orElse(Double.NaN));
    }

    @Override
    public void processArray(double[] array) {
        double absSum = absSum(array);
        double sqrtProd = sqrtProd(array);

        System.out.format("1: %c|a|: %f%n", '\u2211', absSum);
        System.out.format("1: %c%c : %f%n", '\u221a', '\u220f', sqrtProd);

    }
}
