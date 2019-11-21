package te.homework.lab3.task5;

import te.homework.lab3.Task;

class Task5 extends Task {

    Task5() {
        super();
    }

    Task5(char[] delimiters) {
        super(delimiters);
    }

    String insertWord(String word, int index, String input) {
        return onWordFind(str -> str.length() >= index
                        ? str.substring(0, index) + word + str.substring(index)
                        : str,
                input);
    }
}
