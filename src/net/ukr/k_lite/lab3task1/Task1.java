package net.ukr.k_lite.lab3task1;

public class Task1 {
    private String spaces;

    public Task1() {
        this.spaces = " ";
    }

    public Task1(String spaces) {
        this.spaces = spaces;
    }

    public String replace(int index, char replaceChar, String input) {
        StringBuilder output = new StringBuilder(input.length());

        boolean inWord;
        int wordIndex = 0;

        for (char c: input.toCharArray()) {
            if (spaces.contains("" + c)) {
                inWord = false;
                wordIndex = 0;
            } else {
                inWord = true;
            }

            if (inWord) {
                wordIndex += 1;
            }

            if (inWord && wordIndex == index) {
                output.append(replaceChar);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }
}
