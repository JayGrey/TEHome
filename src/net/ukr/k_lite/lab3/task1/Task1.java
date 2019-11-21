package net.ukr.k_lite.lab3.task1;

import net.ukr.k_lite.lab3.Task;


class Task1 extends Task {

    Task1(char[] delimiters) {
        super(delimiters);
    }

    Task1() {
        super();
    }

    String replace(int wordLength, char replaceChar, String input) {
        return onWordFind(
                str -> wordLength > str.length()
                        ? str
                        : str.substring(0, wordLength - 1) + replaceChar + str.substring(wordLength),
                input
        );
    }
}
