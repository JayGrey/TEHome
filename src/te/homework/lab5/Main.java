package te.homework.lab5;

public class Main {
    private static void prettyPrint(
            String message, Task task, double[] vector, double[][] matrix) {
        System.out.format("========== [ %s ] ==========%n", message);
        task.processArray(vector);
        task.processArray(matrix);
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleArrayReader reader = new DoubleArrayReaderImpl();

        double[] lab51Array = reader.readOneDimensionalArray("lab51.txt");
        double[][] lab52Array = reader.readTwoDimensionalArray("lab52.txt");

        // Tasks
        prettyPrint("task 5.1", new Task1(), lab51Array, lab52Array);
        prettyPrint("task 5.2", new Task2(), lab51Array, lab52Array);
        prettyPrint("task 5.3", new Task3(), lab51Array, lab52Array);
    }
}
