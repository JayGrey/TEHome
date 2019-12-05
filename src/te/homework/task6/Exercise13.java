package te.homework.task6;

import java.util.List;

/*
 Не используя вспомогательных объектов, переставить отрицательные элементы данного
списка в конец, а положительные — в начало списка.
 */
public interface Exercise13 {
    static void reorderList(List<Double> list) {
        if (list == null || list.size() == 0) {
            return;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i != j) {

            while (i < j && list.get(i) >= 0) {
                i += 1;
            }

            while (j > i && list.get(j) < 0) {
                j -= 1;
            }

            if (i != j) {
                double tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
            }
        }
    }
}
