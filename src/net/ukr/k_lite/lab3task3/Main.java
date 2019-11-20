/*
Ввести текст, що складається з декількох слів. В тексті після літери Р (або р),
якщо вона не остання в слові, може зустрічатися літера А (або а). У такому випадку
замінити її на літеру О (або о).
Вивести початковий та змінений рядок.
*/

package net.ukr.k_lite.lab3task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Task3 task3 = new Task3();

        System.out.println("input: " + input);
        System.out.println("output:" + task3.changeSubstring(input));
    }
}
