package net.ukr.k_lite.lab3task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        char ch = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();

        Task1 task1 = new Task1();
        String result = task1.replace(k, ch, input);

        System.out.println(result);
    }
}
