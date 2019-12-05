package te.homework.task6;

import java.util.Arrays;

/*
    Списки (стеки, очереди) I(1..n) и U(1..n) содержат результаты n-измерений тока и напряжения
    на неизвестном сопротивлении R.

    Найт приблеженное число R методом наименьших квадратов.
*/

public class Main9 {
    public static void main(String[] args) {

        double r = Exercise9.findK(
                Arrays.asList(1.0, 2.0, 2.0, 3.0, 5.0, 3.0, 4.0, 7.0),
                Arrays.asList(2.0, 2.0, 4.0, 4.0, 5.0, 6.0, 8.0, 10.0)
        );

        System.out.println("R= " + r);
    }
}
