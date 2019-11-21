/*
Ввести з клавіатури ціле число k та деяку літеру (символ).
Після введення цих даних, ввести один рядок тексту.

В кожному слові тексту k-у літеру замінити введеним.

Якщо k більше довжини слова, коригування не виконувати.
Вивести змінений текст.
*/

package te.homework.lab3.task1;


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
