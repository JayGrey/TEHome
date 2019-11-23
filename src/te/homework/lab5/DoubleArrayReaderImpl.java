package te.homework.lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DoubleArrayReaderImpl implements DoubleArrayReader {
    @Override
    public double[] readOneDimensionalArray(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            // skip first line with number of elements
            reader.readLine();

            return Utils.StringToDoubleArray(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return new double[0];
        }
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        return readOneDimensionalArray(new File(fileName));
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int numRows = Integer.parseInt(reader.readLine());

            double[][] result = new double[numRows][];

            for (int i = 0; i < numRows; i++) {
                result[i] = Utils.StringToDoubleArray(reader.readLine());

                if (result[i].length != numRows) {
                    System.err.format("line %d has %d elements, but %d expected%n", i + 1,
                            result[i].length, numRows);
                    return new double[0][];
                }
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return new double[0][];
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        return readTwoDimensionalArray(new File(fileName));
    }
}
