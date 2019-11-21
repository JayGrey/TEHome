
/*
Ввести текст, що крім літер та пропусків може містити інші символи.

Вилучити з нього всі символи, крім пропусків, які не є літерами.

Між послідовностями літер, що йдуть безпосередньо одна за одною,
залишити хоча би по одному пропуску.

Вивести рядок до та після опрацювання.
*/

package te.homework.lab3.task8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input: ");
        String input = scanner.nextLine();

        String output = new Task8().removeNonAlphaCharsInWords(input);

        System.out.println("input:  " + input);
        System.out.println("output: " + output);
    }
}
