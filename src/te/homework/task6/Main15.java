package te.homework.task6;


import java.util.List;
import java.util.Map;

/*
Задан файл с текстом на английском языке. Выделить все различные слова. Слова,
отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashMap
* */
public class Main15 {

    public static void main(String[] args) {
        List<String> lines = Exercise15.getLines("raven.text");
        Map<String, Long> wordsFrequency = Exercise15.findWordsFrequency(lines);
        wordsFrequency.forEach((k, v) -> System.out.format("%s - %d%n", k, v));
    }
}
