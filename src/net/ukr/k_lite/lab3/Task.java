package net.ukr.k_lite.lab3;

import java.util.Objects;
import java.util.function.UnaryOperator;

public class Task {
    private char[] delimiters;

    public Task() {
        this(new char[]{' '});
    }

    public Task(char[] delimiters) {
        Objects.requireNonNull(delimiters);

        this.delimiters = delimiters;
    }

    public boolean isDelimiter(char ch) {

        for (char delimiter : delimiters) {
            if (delimiter == ch) {
                return true;
            }
        }
        return false;
    }

    public int countWords(String input) {
        int words = 0;
        boolean inWord = false;

        for (char ch : input.toCharArray()) {
            if (isDelimiter(ch)) {
                if (inWord) {
                    words += 1;
                }
                inWord = false;
            } else {
                inWord = true;
            }
        }

        if (inWord) {
            words += 1;
        }

        return words;
    }

    public String onWordFind(UnaryOperator<String> func, String input) {
        StringBuilder output = new StringBuilder();
        int wordLength = 0;

        for (int i = 0; i < input.length(); i++) {
            final char ch = input.charAt(i);

            if (isDelimiter(ch)) {

                if (wordLength > 0) {
                    output.append(func.apply(input.substring(i - wordLength, i)));
                }

                wordLength = 0;
                output.append(ch);
            } else {
                wordLength += 1;
            }
        }

        final int inputLength = input.length();
        if (wordLength > 0) {
            output.append(func.apply(input.substring(inputLength - wordLength, inputLength)));
        }

        return output.toString();
    }
}
