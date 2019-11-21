package net.ukr.k_lite.lab3task6;

import net.ukr.k_lite.lab3.Task;

class Task6 extends Task {

    Task6() {
        super();
    }

    Task6(char[] chars) {
        super(chars);
    }


    String insertAfter(String s, String t, String input) {
        return onWordFind(str -> str.endsWith(s) ? str + t : str, input);
    }
}
