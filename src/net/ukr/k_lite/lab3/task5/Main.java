/*
Ввести текст, короткий рядок та ціле число k. В тексті після k-го символу
вставити заданий короткий рядок. Вивести рядок після опрацювання та ціле число –
кількість слів у отриманому рядку.
* */

package net.ukr.k_lite.lab3.task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input: ");
        String input = scanner.nextLine();

        System.out.print("suffix: ");
        String suffix = scanner.nextLine();

        System.out.print("k: ");
        int k = scanner.nextInt();

        print(input, suffix, k);
    }

    private static void print(String input, String suffix, int index) {
        Task5 task5 = new Task5();
        String output = task5.insertWord(suffix, index, input);
        int numberOfWords = task5.countWords(output);

        System.out.println("input:      " + input);
        System.out.println("output:     " + output);
        System.out.println("# of words: " + numberOfWords);
    }
}
