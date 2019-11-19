package net.ukr.k_lite.lab3task10;

class Task10 {
    private String spaces;

    Task10() {
        this(" ");
    }

    Task10(String spaces) {
        this.spaces = spaces;
    }

    String removeChars(String input, char openDelimiter, char closeDelimiter) {

        int openPos = input.indexOf(openDelimiter);
        int closePos = input.indexOf(closeDelimiter, openPos + 1);

        return (openPos == -1 || closePos == -1)
                ? input
                : input.substring(0, openPos + 1)
                + removeChars(input.substring(closePos), openDelimiter, closeDelimiter);

    }

    String removeChars(String input, char delimiter) {
        return removeChars(input, delimiter, delimiter);
    }

    int countWords(String input) {
        int numberOfWords = 0;
        boolean isWord = false;

        for (char c : input.toCharArray()) {
            if (spaces.contains("" + c)) {
                isWord = false;
            } else if (!isWord) {
                isWord = true;
                numberOfWords += 1;
            }
        }

        return numberOfWords;
    }
}
