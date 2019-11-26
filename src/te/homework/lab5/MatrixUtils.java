package te.homework.lab5;

import java.util.Arrays;
import java.util.stream.DoubleStream;

class MatrixUtils {
    private static boolean checkBoundaries(
            int fromRow, int toRow,
            int fromColumn, int toColumn,
            double[][] input) {
        return input != null
                && (toRow - fromRow) == (toColumn - fromColumn)
                && (toRow - fromRow) >= 0
                && fromRow >= 0
                && fromColumn >= 0
                && toRow < input.length
                && toColumn < input.length;
    }

    private static int getArraySize(int n) {
        return ((n + 1) * n) / 2;
    }

    private static double[] upperLeftTriangle(
            final int fromRow, final int toRow,
            final int fromColumn, final int toColumn,
            double[][] input) {
        double[] result = new double[getArraySize(toRow - fromRow + 1)];
        int columnOffset = 0;
        int resultArrayIndex = 0;

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromColumn; j <= toColumn - columnOffset; j++) {
                result[resultArrayIndex] = input[i][j];
                resultArrayIndex += 1;
            }
            columnOffset += 1;
        }
        return result;
    }

    private static double[] upperRightTriangle(
            final int fromRow, final int toRow,
            final int fromColumn, final int toColumn,
            double[][] input) {
        double[] result = new double[getArraySize(toRow - fromRow + 1)];
        int resultArrayIndex = 0;
        int columnOffset = 0;
        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromColumn + columnOffset; j <= toColumn; j++) {
                result[resultArrayIndex] = input[i][j];
                resultArrayIndex += 1;
            }
            columnOffset += 1;
        }
        return result;
    }

    private static double[] lowerRightTriangle(
            final int fromRow, final int toRow,
            final int fromColumn, final int toColumn,
            double[][] input
    ) {
        double[] result = new double[getArraySize(toRow - fromRow + 1)];
        int resultArrayIndex = 0;
        int columnOffset = 0;
        for (int i = fromRow; i <= toRow; i++) {
            for (int j = toColumn - columnOffset; j <= toColumn; j++) {
                result[resultArrayIndex] = input[i][j];
                resultArrayIndex += 1;
            }
            columnOffset += 1;
        }
        return result;
    }

    private static double[] lowerLeftTriangle(
            final int fromRow, final int toRow,
            final int fromColumn, final int toColumn,
            double[][] input
    ) {
        double[] result = new double[getArraySize(toRow - fromRow + 1)];
        int resultArrayIndex = 0;
        int columnOffset = 0;
        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromColumn; j <= fromColumn + columnOffset; j++) {
                result[resultArrayIndex] = input[i][j];
                resultArrayIndex += 1;
            }
            columnOffset += 1;
        }
        return result;
    }

    private static double[] rectangle(
            final int fromRow, final int toRow,
            final int fromColumn, final int toColumn,
            double[][] input
    ) {
        double[] result = new double[(toRow - fromRow + 1) * (toColumn - fromColumn + 1)];
        int arrayIndex = 0;

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromColumn; j <= toColumn; j++) {
                result[arrayIndex] = input[i][j];
                arrayIndex += 1;
            }
        }

        return result;
    }

    static double[] cutFigure(int fromRow, int toRow, int fromColumn, int toColumn, Figure figure
            , double[][] input) {


        switch (figure) {
            case UPPER_LEFT: {
                return checkBoundaries(fromRow, toRow, fromColumn, toColumn, input) ?
                        upperLeftTriangle(fromRow, toRow, fromColumn, toColumn, input)
                        : new double[0];
            }

            case UPPER_RIGHT: {
                return checkBoundaries(fromRow, toRow, fromColumn, toColumn, input) ?
                        upperRightTriangle(fromRow, toRow, fromColumn, toColumn, input) :
                        new double[0];
            }

            case LOWER_RIGHT: {
                return checkBoundaries(fromRow, toRow, fromColumn, toColumn, input) ?
                        lowerRightTriangle(fromRow, toRow, fromColumn, toColumn, input) :
                        new double[0];
            }

            case LOWER_LEFT: {
                return checkBoundaries(fromRow, toRow, fromColumn, toColumn, input) ?
                        lowerLeftTriangle(fromRow, toRow, fromColumn, toColumn, input) :
                        new double[0];
            }

            case RECTANGLE: {
                return rectangle(fromRow, toRow, fromColumn, toColumn, input);
            }

            default: {
                return new double[0];
            }
        }
    }

    static DoubleStream cutFigureAndReturnStream(
            int fromRow, int toRow,
            int fromColumn, int toColumn,
            Figure figure, double[][] input) {
        return Arrays.stream(cutFigure(fromRow, toRow, fromColumn, toColumn, figure, input));
    }

    enum Figure {UPPER_LEFT, UPPER_RIGHT, LOWER_LEFT, LOWER_RIGHT, RECTANGLE}
}
