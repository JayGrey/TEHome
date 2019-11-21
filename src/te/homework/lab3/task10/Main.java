/*
Варіант 10
Ввести текст, що містить пару спеціальних символів, які вводяться
(наприклад, дужки ‘(’ та ‘)’ або зірочки ‘*’ .). Видалити з тексту всі символи між
вказаними символами. Вивести початковий рядок та рядок після опрацювання та
число - кількість слів у опрацьованому рядку.
*/

package te.homework.lab3.task10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        char openDelimiter = scanner.nextLine().charAt(0);
        char closeDelimiter = scanner.nextLine().charAt(0);

        Task10 task10 = new Task10();
        String resultString = task10.removeChars(inputString, openDelimiter, closeDelimiter);
        System.out.println("input: " + inputString);
        System.out.println("result: " + resultString);
        System.out.println("words: " + task10.countWords(resultString));
    }
}
