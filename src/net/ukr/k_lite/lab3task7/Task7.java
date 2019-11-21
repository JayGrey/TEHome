package net.ukr.k_lite.lab3task7;

import net.ukr.k_lite.lab3.Task;

import java.util.function.UnaryOperator;

class Task7 extends Task {

    Task7(char[] delimiters) {
        super(delimiters);
    }

    Task7() {
        super();
    }

    private UnaryOperator<String> processWord(char ch, int wordLength) {
        return str -> {
            if (str.length() > wordLength) {
                StringBuilder output = new StringBuilder();
                for (char c : str.toCharArray()) {
                    if (ch != c) {
                        output.append(c);
                    }
                }
                return output.toString();
            } else {
                return str;
            }
        };
    }

    String replace(char ch, int k, String input) {
        return onWordFind(processWord(ch, k), input);
    }
}
