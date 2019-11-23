package te.homework.lab5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleArrayReaderImplTest {

    private static final double EPSILON = 1e-8;

    @Test
    void readOneDimensionalArray(@TempDir Path tempDir) {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        Path file = tempDir.resolve("test-lab51.txt");

        double[] expected = {-1, -2, 0, 3, 10};
        prepareFile(file, expected);

        double[] result = reader.readOneDimensionalArray(file.toFile());

        assertArrayEquals(expected, result, EPSILON);
    }

    @Test
    void readOneDimensionalArrayWithNonDigitElement(@TempDir Path tempDir) {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        Path file = tempDir.resolve("test-lab51.txt");

        prepareFile(file, new String[]{"3", "1 2 -a"});

        double[] result = reader.readOneDimensionalArray(file.toFile());

        assertArrayEquals(new double[0], result, EPSILON);
    }

    @Test
    void readOneDimensionalArrayWithNonExistingFile() {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        double[] result = reader.readOneDimensionalArray("abc def");

        assertEquals(0, result.length);
    }

    @Test
    void readTwoDimensionalArray(@TempDir Path tempDir) {
        double[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Path file = tempDir.resolve("test-lab52.txt");

        DoubleArrayReaderImpl reader = new DoubleArrayReaderImpl();
        prepareFile(file, expected);

        double[][] result = reader.readTwoDimensionalArray(file.toFile());

        assertEquals(expected.length, result.length);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], EPSILON);
        }

    }

    @Test
    void readTwoDimensionalArrayWithNonDigitElement(@TempDir Path tempDir) {
        Path file = tempDir.resolve("test-lab52.txt");

        DoubleArrayReaderImpl reader = new DoubleArrayReaderImpl();
        prepareFile(file, new String[]{"3", "1.0 2.0 3.0", "4.0 5.o 6.0", "7.0 8.0 9.0"});

        double[][] result = reader.readTwoDimensionalArray(file.toFile());

        assertEquals(0, result.length);
    }

    @Test
    void readTwoDimensionalArrayWithNonExistingFile() {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        double[][] result = reader.readTwoDimensionalArray("abc def");

        assertEquals(0, result.length);
    }

    private void prepareFile(Path file, double[] values) {
        String[] data = {
                String.valueOf(values.length),
                Utils.doubleArrayToString(values),
        };

        prepareFile(file, data);
    }

    private void prepareFile(Path file, double[][] values) {
        String[] strings = Stream.concat(
                Stream.of(String.valueOf(values[0].length)),
                Stream.of(values)
                        .map(Utils::doubleArrayToString))
                .toArray(String[]::new);

        prepareFile(file, strings);
    }

    private void prepareFile(Path file, String[] lines) {
        try (PrintWriter writer = new PrintWriter(file.toFile())) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
