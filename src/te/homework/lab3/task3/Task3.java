package te.homework.lab3.task3;

import te.homework.lab3.Task;

class Task3 extends Task {

    String changeSubstring(String input) {
        return onWordFind(str -> str
                        .replace("ра", "ро")
                        .replace("РА", "РО")
                        .replace("Ра", "Ро")
                        .replace("рА", "рО"),
                input);
    }
}
