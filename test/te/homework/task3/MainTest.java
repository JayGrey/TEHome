package te.homework.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DisplayName("task 3 tests")
class MainTest {

    @Test
    void getDigitsSum() {
        assertEquals(3, Main.getDigitsSum(111));
        assertEquals(0, Main.getDigitsSum(0));
        assertEquals(6, Main.getDigitsSum(-15));
        assertEquals(1, Main.getDigitsSum(-1));
    }

    @Test
    void stringToListIntegers() {
        assertEquals(0, Main.stringToListIntegers("abc def afa").size());

        assertIterableEquals(Arrays.asList(1, 2, 3), Main.stringToListIntegers("1 2 3"));
        assertIterableEquals(Arrays.asList(1, 2, 3), Main.stringToListIntegers("1 2 a 3 b"));
        assertIterableEquals(Collections.singletonList(1000), Main.stringToListIntegers("1000"));
        assertIterableEquals(Collections.singletonList(-1000), Main.stringToListIntegers("-1000"));

        assertIterableEquals(Collections.emptyList(), Main.stringToListIntegers(""));
    }

    @Test
    void getDataFromFile(@TempDir Path tempDir) {
        String filename = tempDir.resolve("input.txt").toString();

        fillFileWithData(filename, new String[]{" adb", "123", " ad 65 23 11 ", "", " -987  "});
        List<Integer> list = Main.getDataFromFile(filename);

        assertIterableEquals(Arrays.asList(123, 65, 23, 11, -987), list);
    }

    @Test
    void getDataFromEmptyFile(@TempDir Path tempDir) {
        String filename = tempDir.resolve("input.txt").toString();

        fillFileWithData(filename, new String[]{""});
        List<Integer> list = Main.getDataFromFile(filename);

        assertEquals(0, list.size());
    }

    @Test
    void getDataFromNonExistingFile(@TempDir Path tempDir) {
        String filename = tempDir.resolve("input123.txt").toString();

        List<Integer> list = Main.getDataFromFile(filename);
        assertEquals(0, list.size());
    }

    @Test
    void writeNumbersInReversedOrder(@TempDir Path tempDir) {
        String filename = tempDir.resolve("reversed.txt").toString();

        Main.writeNumbersInReversedOrder(filename, Arrays.asList(1, 2, 3, 4));
        List<String> lines = getDataFromFile(filename);

        assertIterableEquals(Arrays.asList("4", "3", "2", "1"), lines);
    }

    @Test
    void writeDigitsSumToFile(@TempDir Path tempDir) {
        String filename = tempDir.resolve("digitsum.txt").toString();

        Main.writeDigitsSumToFile(filename, Arrays.asList(1, 123, -56, 0));
        List<String> lines = getDataFromFile(filename);

        assertIterableEquals(Arrays.asList("1", "6", "11", "0"), lines);

    }

    private void fillFileWithData(String filename, String[] lines) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }
    }

    private List<String> getDataFromFile(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}