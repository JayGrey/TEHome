package te.homework.lab5;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public interface ConvertUtils {
    static String doubleArrayToString(double[] arr) {
        return DoubleStream.of(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    static double[] StringToDoubleArray(String input) {
        try {
            return Stream.of(input.trim().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        } catch (NumberFormatException e) {
            e.printStackTrace(System.err);
            return new double[0];
        }
    }

}
