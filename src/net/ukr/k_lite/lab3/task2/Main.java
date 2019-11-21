/*
Ввести один рядок тексту. В тексті кожну літеру замінити її порядковим
номером в алфавіті. Вивести вхідний рядок та отриманий рядок наступним чином:
при виведенні в одному рядку друкувати текст з двома пропусками між літерами, в
наступному рядку внизу під кожною літерою друкувати її номер.
* */

package net.ukr.k_lite.lab3.task2;


import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static void print(String input) {
        Task2 task2 = new Task2();

        System.out.print("  ");
        input.chars().forEach(ch -> System.out.format("  %c  ", ch));

        System.out.println();

        IntStream.of(task2.getCharsPos(input)).forEach(num -> System.out.format("%5d", num));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        print(input);
    }
}
