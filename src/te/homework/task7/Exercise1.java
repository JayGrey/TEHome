package te.homework.task7;

import java.util.List;

public interface Exercise1 {
    static void reorderList(List<Integer> list, int x) {
        if (list == null || list.size() < 2) {
            return;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            while (left < right && list.get(left) <= x) {
                left += 1;
            }

            while (right > left && list.get(right) > x) {
                right -= 1;
            }

            int tmp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, tmp);
        }
    }
}
