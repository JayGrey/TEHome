package te.homework.task6;


/*
 Не используя вспомогательных объектов, переставить отрицательные элементы данного
списка в конец, а положительные — в начало списка.
 */

import java.util.Arrays;
import java.util.List;

public class Main13 {

    public static void main(String[] args) {
        List<Double> list = Arrays.asList(0.1, -1.0, -5.0, 3.0, 2.0);

        System.out.println("list before: " + list);
        Exercise13.reorderList(list);
        System.out.println("list after: " + list);

    }
}
