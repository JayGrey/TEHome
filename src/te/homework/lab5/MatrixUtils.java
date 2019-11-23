package te.homework.lab5;

class MatrixUtils {
    private static boolean checkBoundaries(int fromRow, int toRow, int fromColumn, int toColumn,
                                           double[][] input) {
        return (toRow - fromRow) == (toColumn - fromColumn)
                && (toRow - fromRow) >= 0
                && fromRow >= 0
                && fromColumn >= 0
                && toRow < input.length
                && toColumn < input.length;
    }

    static double[] cutFigure(int fromRow, int toRow, int fromColumn, int toColumn, Figure figure
            , double[][] input) {

        if (!checkBoundaries(fromRow, toRow, fromColumn, toColumn, input)) {
            return new double[0];
        }

        final int resultArraySize = ((toRow - fromRow + 1) * (toRow - fromRow + 2)) / 2;
        double[] resultArray = new double[resultArraySize];
        int resultArrayIndex = 0;

        switch (figure) {
            case UPPER_LEFT: {
                int columnOffset = 0;
                for (int i = fromRow; i <= toRow; i++) {
                    for (int j = fromColumn; j <= toColumn - columnOffset; j++) {
                        resultArray[resultArrayIndex] = input[i][j];
                        resultArrayIndex += 1;
                    }
                    columnOffset += 1;
                }
                return resultArray;
            }

            case UPPER_RIGHT: {
                int columnOffset = 0;
                for (int i = fromRow; i <= toRow; i++) {
                    for (int j = fromColumn + columnOffset; j <= toColumn; j++) {
                        resultArray[resultArrayIndex] = input[i][j];
                        resultArrayIndex += 1;
                    }
                    columnOffset += 1;
                }
                return resultArray;
            }

            case LOWER_RIGHT: {
                int columnOffset = 0;
                for (int i = fromRow; i <= toRow; i++) {
                    for (int j = toColumn - columnOffset; j <= toColumn; j++) {
                        resultArray[resultArrayIndex] = input[i][j];
                        resultArrayIndex += 1;
                    }
                    columnOffset += 1;
                }
                return resultArray;
            }

            case LOWER_LEFT: {
                int columnOffset = 0;
                for (int i = fromRow; i <= toRow; i++) {
                    for (int j = fromColumn; j <= fromColumn + columnOffset; j++) {
                        resultArray[resultArrayIndex] = input[i][j];
                        resultArrayIndex += 1;
                    }
                    columnOffset += 1;
                }
                return resultArray;
            }

            default: {
                return new double[0];
            }
        }
    }

    enum Figure {UPPER_LEFT, UPPER_RIGHT, LOWER_LEFT, LOWER_RIGHT}
}
