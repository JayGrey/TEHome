package net.ukr.k_lite.conscription;

public class Permutation {
    private final int[] index;
    private final int[] data;

    private Permutation(int[] data) {
        this.data = data;
        this.index = new int[this.data.length];

    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation(new int[]{1, 2, 3, 4, 5, 6});
        permutation.run(0, 5);
    }

    private void print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 1) {
                result.append(data[i]);
            }
        }

        System.out.println(result.toString());
    }

    private void run(int from, int length) {
        if (length == 0) {
            print();
            return;
        }
        for (int i = from; i <= index.length - length; i++) {
            if (index[i] == 0) {
                index[i] = 1;
                run(i + 1, length - 1);
                index[i] = 0;
            }
        }
    }
}
