/*
Для похода на Азерот Оргриму Думхаммеру потребовался еще один отряд. На призыв явились n орков.
Способности в ближнем бою и метании копья каждого из них Оргрим сразу же оценил.
Теперь же он должен определить кого из них назначить солдатом-пехотинцем (grunt), а кого
метателем-охотником за головами (headhunter). При этом, для того, чтобы отряд был боеспособным,
необходимо, чтобы было в отряде было не менее g грунтов и не менее h хедхантеров. После определения
каждого орка в какой-то тип войск, может быть определена сила этого отряда, как сумма способностей
всех орков в назначенной им специализации.

Напишите программу, определяющую максимально возможную силу вновь призванного отряда.

Входные данные
В первой строке заданы три целых числа n, g, h (1 ≤ n ≤ 10000, 0 ≤ g, h ≤ n).
Далее идут n строк, в каждой из которых записаны два целых числа в диапазоне от 0 до 10000
- способность соответствующего орка в ближнем бою и его способность в метании копья.

Выходные данные
Вывести максимальную силу боеспособной армии, которая может быть создана из призывников.
В случае невозможности создания армии, удовлетворяющей заданным условиям, выведите число -1.

 */
package net.ukr.k_lite.conscription;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int MELEE_INDEX = 0;
    private static final int RANGE_INDEX = 1;
    private static int finalSum;
    private static int[] path;
    private static int[][] orcs;

    private static Army getData() {

        Scanner scanner = new Scanner(System.in);
        Army army = new Army(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        int[][] orks = new int[2][army.total];

        for (int i = 0; i < army.total; i++) {
            orks[MELEE_INDEX][i] = scanner.nextInt();
            orks[RANGE_INDEX][i] = scanner.nextInt();
        }
        army.orks = orks;

        return army;
    }

    static int solution(Army army) {

        if (army.grunts + army.headHunters > army.total) {
            return -1;
        }

        path = new int[army.total];
        Arrays.fill(path, 0);

        orcs = army.orks;

        finalSum = -1;

        calculate1(0, army.grunts, 0, army.headHunters);
        return finalSum;
    }

    private static void calculate1(int fromLeft, int lengthLeft, int fromRight, int lengthRight) {
        if (lengthLeft == 0 && lengthRight == 0) {
            int sum = 0;
            for (int i = 0; i < path.length; i++) {
                if (path[i] == -1) {
                    sum += orcs[MELEE_INDEX][i];
                } else if (path[i] == 1) {
                    sum += orcs[RANGE_INDEX][i];
                } else {
                    sum += Math.max(orcs[MELEE_INDEX][i], orcs[RANGE_INDEX][i]);
                }
            }
            if (sum > finalSum) {
                finalSum = sum;
            }
            return;
        }

        // left - melee
        if (lengthLeft > 0) {
            for (int i = fromLeft; i <= path.length - lengthLeft; i++) {
                if (path[i] == 0) {
                    path[i] = -1;
                    calculate1(i + 1, lengthLeft - 1, fromRight, lengthRight);
                    path[i] = 0;
                }
            }
            return;
        }

        // right - range
        if (lengthRight > 0) {
            for (int i = fromRight; i <= path.length - lengthRight; i++) {
                if (path[i] == 0) {
                    path[i] = 1;
                    calculate1(fromLeft, lengthLeft, i + 1, lengthRight - 1);
                    path[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        out.println(solution(getData()));

        out.flush();
    }

    static class Army {
        private final int total;
        private final int grunts;
        private final int headHunters;
        private int[][] orks;

        Army(int total, int grunts, int headHunters) {
            this.total = total;
            this.grunts = grunts;
            this.headHunters = headHunters;
        }

        void setOrks(int[][] orks) {
            this.orks = orks;
        }
    }
}
