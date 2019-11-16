package net.ukr.k_lite.task2;

public class Main {
    public static void main(String[] args) {

        // for
        System.out.println("Generated with for loop");
        Table.print(new GenerateWithForLoop(), 0.0, 1.0, 0.1);

        // while
        System.out.format("%nGenerated with while loop%n");
        Table.print(new GenerateWithWhileLoop(), 0.0, 1.0, 0.1);

        // do while
        System.out.format("%nGenerated with do while loop%n");
        Table.print(new GenerateWithDoWhileLoop(), 0.0, 1.0, 0.1);
    }
}
