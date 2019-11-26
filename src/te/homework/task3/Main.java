package te.homework.task3;

/*
*
есть текстовый файл в котором записаны целые числа, не более 1_000_000.
Числа записаны хаотично, в
одной строке может быть несколько чисел.

В другой файл нужно вывести:
1. числа в обратном порядке, по одному в каждой строке.
2. вывести сумму цифр этих чисел.

* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {

    static int getDigitsSum(int num) {
        return num == 0 ? num : Math.abs(num % 10) + getDigitsSum(num / 10);
    }

    static List<Integer> stringToListIntegers(String input) {

        if (input == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        for (String str : input.split("\\s+")) {
            try {
                result.add(Integer.valueOf(str));
            } catch (NumberFormatException ignored) {
            }
        }

        return result;
    }

    static List<Integer> getDataFromFile(String filename) {
        if (filename == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line = reader.readLine();

            if (line == null) {
                return result;
            }

            result.addAll(stringToListIntegers(line));

            while ((line = reader.readLine()) != null) {
                result.addAll(stringToListIntegers(line));
            }

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        return result;
    }

    static void writeNumbersInReversedOrder(String outputFilename, List<Integer> numbers) {
        if (outputFilename == null || numbers == null || numbers.size() == 0) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(outputFilename)) {
            ListIterator<Integer> iterator = numbers.listIterator(numbers.size());

            while (iterator.hasPrevious()) {
                writer.println(iterator.previous().intValue());
            }

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    static void writeDigitsSumToFile(String outputFilename, List<Integer> numbers) {
        if (outputFilename == null || numbers == null || numbers.size() == 0) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(outputFilename)) {
            for (Integer integer : numbers) {
                writer.println(getDigitsSum(integer));
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = getDataFromFile("numbers.txt");
        writeNumbersInReversedOrder("reversed-file.txt", integerList);
        writeDigitsSumToFile("digits-sum.txt", integerList);
    }
}
