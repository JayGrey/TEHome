package net.ukr.k_lite.lab3task4;

import net.ukr.k_lite.lab3.Task;

class Task4 extends Task {


    Task4(char[] delimiters) {
        super(delimiters);
    }

    Task4() {
        super();
    }

    String changeWord(String replace, int wordLength, String input) {
        return onWordFind(str -> str.length() == wordLength ? replace : str, input);
    }
}
