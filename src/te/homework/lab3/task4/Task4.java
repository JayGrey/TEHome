package te.homework.lab3.task4;

import te.homework.lab3.Task;

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
