/*
Ввести текст і два коротких рядка s та t.

Після кожного слова тексту, яке закінчується рядком s,
вставити вказане слово t.

Вивести початковий рядок та рядок після опрацювання.
 */

package te.homework.lab3.task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("input: ");
        String input = scanner.nextLine();

        System.out.print("s: ");
        String s = scanner.nextLine();

        System.out.print("t: ");
        String t = scanner.nextLine();

        Task6 task6 = new Task6();

        String output = task6.insertAfter(s, t, input);

        System.out.println("input:  " + input);
        System.out.println("output: " + output);
    }
}
