package te.homework.lab5;

public abstract class Task implements ArrayProcessor {
    @Override
    public void processArray(double[] array) {
        System.out.format("1: %f %n", calculate(array));
    }

    @Override
    public void processArray(double[][] array) {
        System.out.format("2: %f %n", calculate(array));
    }
}
