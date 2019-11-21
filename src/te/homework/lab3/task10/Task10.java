package te.homework.lab3.task10;

import te.homework.lab3.Task;

class Task10 extends Task {

    Task10() {
        super();
    }

    Task10(char[] delimiters) {
        super(delimiters);
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

}
