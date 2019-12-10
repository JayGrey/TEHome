package te.homework.task7;

/*


Задан список целых чисел и число X. Не используя вспомогательных
объектов и не изменяя размера списка, переставить элементы списка
так, чтобы сначала шли числа, не превосходящие X, а затем числа,
больше X

* */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        System.out.print("list in:  ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = parseString(scanner.nextLine());

        System.out.print("x: ");
        int x = scanner.nextInt();

        Exercise1.reorderList(list, x);
        System.out.println("list out: " + listToString(list));
    }

    private static List<Integer> parseString(String input) {
        try {
            return Arrays.stream(input.split("\\s+|,"))
                    .filter(s -> s.length() > 0)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }

    private static String listToString(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
