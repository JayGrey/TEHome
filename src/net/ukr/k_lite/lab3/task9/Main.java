/*
Ввести текст та ціле число – довжину слова.

З тексту вилучити всі слова
вказаної довжини, які починаються на приголосну літеру.

Вивести початковий рядок та рядок після опрацювання.
*/

package net.ukr.k_lite.lab3.task9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input: ");
        String input = scanner.nextLine();

        System.out.print("length: ");
        int wordLength = scanner.nextInt();

        System.out.println("input: " + input);
        System.out.println("output: " + new Task9().removeWordsThatStartWithConsonantChars(wordLength, input));
    }
}
