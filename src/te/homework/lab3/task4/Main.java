/*
Ввести текст, що складається з декількох слів, ввести рядок, що буде
використовуватися для заміни та довжину слів, які треба замінити.
В тексті слова вказаної довжини замінити введеним рядком.
Довжина рядка, який використовуватиметься для заміни, може не співпадати з довжиною слова.
Вивести рядок.
*/

package te.homework.lab3.task4;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String replace = scanner.nextLine();
        int wordLength = scanner.nextInt();

        Task4 task4 = new Task4();

        System.out.println("output: " + task4.changeWord(replace, wordLength, input));
    }
}
