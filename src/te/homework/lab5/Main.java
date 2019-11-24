package te.homework.lab5;

public class Main {
    private static void prettyPrint(
            String message, ArrayProcessor processor, double[] vector, double[][] matrix) {
        System.out.format("========== [ %s ] ==========%n", message);
        System.out.format("1: %f %n", processor.calculate(vector));
        System.out.format("2: %f %n", processor.calculate(matrix));
        System.out.format("==================================%n");
    }

    public static void main(String[] args) {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        double[] lab51Array = reader.readOneDimensionalArray("lab51.txt");
        double[][] lab52Array = reader.readTwoDimensionalArray("lab52.txt");

        // Task1
        prettyPrint("task 5.1", new Task1ArrayProcessor(), lab51Array, lab52Array);
        prettyPrint("task 5.2", new Task2ArrayProcessor(), lab51Array, lab52Array);
    }
}
