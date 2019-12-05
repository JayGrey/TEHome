package te.homework.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public interface Exercise15 {
    static List<String> getLines(String filename) {
        if (filename == null) {
            return Collections.emptyList();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            List<String> lines = new ArrayList<>();

            while (reader.ready()) {
                lines.add(reader.readLine());
            }

            return lines;
        } catch (IOException e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }

    static Map<String, Long> findWordsFrequency(List<String> lines) {
        if (lines == null || lines.size() == 0) {
            return Collections.emptyMap();
        }

        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split("[^a-zA-Z0-9]")))
                .filter(line -> line.length() > 0)
                .collect(Collectors.groupingBy(String::toLowerCase, HashMap::new, Collectors.counting()));
    }
}
