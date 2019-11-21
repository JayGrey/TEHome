package te.homework.lab3.task8;

import te.homework.lab3.Task;

import java.util.function.UnaryOperator;

class Task8 extends Task {

    Task8() {
        super();
    }

    Task8(char[] delimiters) {
        super(delimiters);
    }

    private UnaryOperator<String> processWord() {
        return str -> {
            StringBuilder output = new StringBuilder();

            for (char ch : str.toCharArray()) {
                if (Character.isAlphabetic(ch)) {
                    output.append(ch);
                }
            }
            return output.toString();
        };
    }

    String removeNonAlphaCharsInWords(String input) {
        return onWordFind(processWord(), input);
    }
}
