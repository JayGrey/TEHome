package net.ukr.k_lite.conscription;

public class Permutation {
    private final int[] index;
    private final int[] data;

    private Permutation(int[] data) {
        this.data = data;
        this.index = new int[this.data.length];

    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation(new int[]{1, 2, 3, 4});
        permutation.run(0, 2, 0, 1);
    }

    private void print() {
        StringBuilder resultLeft = new StringBuilder();
        StringBuilder resultRight = new StringBuilder();

        for (int i = 0; i < index.length; i++) {
            if (index[i] == 1) {
                resultLeft.append(data[i]);
            } else if (index[i] == -1) {
                resultRight.append(data[i]);
            }
        }

        System.out.println("l:" + resultLeft.toString() + " r:" + resultRight.toString());
    }

    private void run(int fromLeft, int lengthLeft, int fromRight, int lengthRight) {
        if (lengthLeft == 0 && lengthRight == 0) {
            print();
            return;
        }

        // left
        if (lengthLeft > 0) {
            for (int i = fromLeft; i <= index.length - lengthLeft; i++) {
                if (index[i] == 0) {
                    index[i] = 1;
                    run(i + 1, lengthLeft - 1, fromRight, lengthRight);
                    index[i] = 0;
                }
            }
            return;
        }

        // right
        if (lengthRight > 0) {
            for (int i = fromRight; i <= index.length - lengthRight; i++) {
                if (index[i] == 0) {
                    index[i] = -1;
                    run(fromLeft, lengthLeft, i + 1, lengthRight - 1);
                    index[i] = 0;
                }
            }
        }
    }
}
