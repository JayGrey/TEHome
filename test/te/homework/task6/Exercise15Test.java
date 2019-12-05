package te.homework.task6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise15Test {

    @Test
    void findWordsFrequency() {

        List<String> list = Arrays.asList("abc def 123", "Abc dEf 123");

        Map<String, Long> map = Exercise15.findWordsFrequency(list);

        assertEquals(3, map.size());
        assertEquals(2, map.get("abc"));
        assertEquals(2, map.get("def"));
        assertEquals(2, map.get("123"));
    }


    @Test
    void findWordsFrequencyWithOtherSeparators() {

        List<String> list = Arrays.asList("abc, def.123", "Abc dEf 123", "  ", ",.  .,");

        Map<String, Long> map = Exercise15.findWordsFrequency(list);

        assertEquals(3, map.size());
        assertEquals(2, map.get("abc"));
        assertEquals(2, map.get("def"));
        assertEquals(2, map.get("123"));
    }

    @Test
    void findWordsFrequencyWithTrashInput() {
        Map<String, Long> map = Exercise15.findWordsFrequency(null);

        assertEquals(0, map.size());
    }

    @Test
    void getLines(@TempDir Path tempDir) {
        Path filePath = tempDir.resolve("test.text");
        prepareFile(filePath, new String[]{"a", "b", "c"});
        List<String> lines = Exercise15.getLines(filePath.toString());

        assertEquals(3, lines.size());
    }

    @Test
    void getLinesFromEmptyFile(@TempDir Path tempDir) {
        Path filePath = tempDir.resolve("test.text");
        prepareFile(filePath, new String[]{});
        List<String> lines = Exercise15.getLines(filePath.toString());

        assertEquals(0, lines.size());
    }

    @Test
    void getLinesFromNonExistFile() {
        List<String> lines = Exercise15.getLines("afafafafaf");
        assertEquals(0, lines.size());

        lines = Exercise15.getLines(null);
        assertEquals(0, lines.size());
    }

    private void prepareFile(Path filename, String[] lines) {
        try (PrintWriter writer = new PrintWriter(filename.toFile())) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
