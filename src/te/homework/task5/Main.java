/*
Прочитать текст из файлы и вывести на экран все уникальные слова
* */

package te.homework.task5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (String line : getFileLines("raven.text")) {
            words.addAll(Arrays.asList(line.split("[^a-zA-Z]")));
        }

        words.removeIf(w -> w.length() < 2);

        for (String word : words) {
            System.out.println(word.toLowerCase());
        }
    }

    static List<String> getFileLines(String filename) {
        try {
            return Files.lines(Paths.get(filename)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }
}
