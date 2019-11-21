/*
Ввести текст, один символ та ціле число k.

В кожному слові тексту, що має
довжину більшу k видалити введений символ.

Вивести рядок до та після
опрацювання.
* */

package net.ukr.k_lite.lab3.task7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input: ");
        String input = scanner.nextLine();

        System.out.print("character: ");
        char ch = scanner.nextLine().charAt(0);

        System.out.print("k: ");
        int k = scanner.nextInt();

        System.out.println("input:  " + input);
        System.out.println("output: " + new Task7().replace(ch, k, input));
    }
}
