package te.homework.lab5;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        double[] lab51Array = reader.readOneDimensionalArray("lab51.txt");
        double[][] lab52Array = reader.readTwoDimensionalArray("lab52.txt");

        Stream.of(
                new Task1(), new Task2(),
                new Task3(), new Task4(),
                new Task5(), new Task6(),
                new Task7(), new Task8()
        ).forEach(t -> {
            System.out.format("========== [ %s ] ==========%n", t.getClass().getSimpleName());
            t.processArray(lab51Array);
            t.processArray(lab52Array);
            System.out.println();
        });
    }
}
