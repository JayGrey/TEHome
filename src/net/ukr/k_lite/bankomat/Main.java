/*
Банкомат
В банкомате имеются в достаточном количестве купюры номиналом 10, 20, 50, 100, 200 и 500 гривен.
Найти минимальное количество купюр, которое необходимо использовать, чтобы выдать сумму в n гривен
или вывести -1, если указанную сумму выдать нельзя.

Входные данные
Одно число n (1 ≤ n ≤ 1000000).

Выходные данные
Наименьшее количество купюр, которыми можно выдать n гривен.

in 770
out 4

* */

package net.ukr.k_lite.bankomat;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static int[] banknotes = new int[]{500, 200, 100, 50, 20, 10};

    static int solution(int n) {
        int result = 0;
        boolean changed = false;

        while (n > 0) {
            changed = false;
            for (int banknote : banknotes) {
                if (banknote <= n) {
                    result += 1;
                    n -= banknote;
                    changed = true;
                    break;
                }
            }

            if (!changed) {
                break;
            }
        }

        return changed ? result : -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int input = in.nextInt();

        out.println(solution(input));

        out.flush();
    }
}
