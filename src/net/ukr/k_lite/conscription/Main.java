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

* */
package net.ukr.k_lite.conscription;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int MELEE_INDEX = 0;
    private static final int RANGE_INDEX = 1;
    private static int leftBranch = 0;
    private static int rightBranch = 0;
    private static Map<String, Integer> values = new HashMap<>();
    private static int[] path;
    private static int[][] orcs;

    private static Army getData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Army army = null;


        try {
            int[] header = stringToIntArray(reader.readLine());
            army = new Army(header[0], header[1], header[2]);

            int[][] orks = new int[2][army.total];

            for (int i = 0; i < army.total; i++) {
                int[] orcData = stringToIntArray(reader.readLine());
                orks[MELEE_INDEX][i] = orcData[MELEE_INDEX];
                orks[RANGE_INDEX][i] = orcData[RANGE_INDEX];
            }
            army.orks = orks;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return army;
    }

    static int solution(Army army) {

        if (army.grunts + army.headHunters > army.total) {
            return -1;
        }

        leftBranch = 0;
        rightBranch = 0;

        path = new int[army.total];
        Arrays.fill(path, 0);

        orcs = army.orks;

        values.clear();

        calculate(army.grunts, army.headHunters);

        return values.values().stream().max(Comparator.comparingInt(a -> a)).orElse(-1);
    }

    private static void calculate(int melee, int range) {
        if (melee == 0 && range == 0) {

            int sum = 0;
            for (int i = 0; i < path.length; i++) {
                if (path[i] == 0) {
                    sum += Math.max(orcs[MELEE_INDEX][i], orcs[RANGE_INDEX][i]);
                } else if (path[i] == 1) {
                    sum += orcs[RANGE_INDEX][i];
                } else if (path[i] == -1) {
                    sum += orcs[MELEE_INDEX][i];
                }
            }
            ///
            values.put("" + leftBranch + '-' + rightBranch, sum);
            return;
        }

        // melee branch - left
        for (int i = 0; i < melee; i++) {
            for (int j = 0; j < path.length; j++) {
                if (path[j] == 0) {
                    path[j] = -1;
                    leftBranch += j;
                    calculate(melee - 1, range);
                    path[j] = 0;
                    leftBranch -= j;
                }
            }
        }

        // range branch - right
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < path.length; j++) {
                if (path[j] == 0) {
                    path[j] = 1;
                    rightBranch += j;
                    calculate(melee, range - 1);
                    path[j] = 0;
                    rightBranch -= j;
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        out.println(solution(getData()));

        out.flush();
    }

    private static int[] stringToIntArray(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
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
