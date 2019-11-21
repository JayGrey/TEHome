package net.ukr.k_lite.lab3task9;

import net.ukr.k_lite.lab3.Task;

class Task9 extends Task {

    private static final String VOWELS = "aeiouyаеёийоуюя";

    Task9() {
        super();
    }

    Task9(char[] delimiters) {
        super(delimiters);
    }

    private boolean isStartsWithConsonant(String string) {
        final char firstChar = Character.toLowerCase(string.charAt(0));

        return Character.isAlphabetic(firstChar) && !VOWELS.contains("" + firstChar);
    }


    String removeWordsThatStartWithConsonantChars(int wordLength, String input) {
        return onWordFind(str -> str.length() == wordLength && isStartsWithConsonant(str) ? "" : str, input);
    }
}
