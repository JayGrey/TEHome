package net.ukr.k_lite.lab3task3;

public class Task3 {

    public String changeSubstring(String input) {

        final int DIFF = 'О' - 'А';
        char previousChar = input.charAt(0);
        StringBuilder output = new StringBuilder(input.length());

        for (char ch : input.toCharArray()) {
            if (
                    Character.toUpperCase(previousChar) == 'Р'
                            && Character.toUpperCase(ch) == 'А'
            ) {
                output.append((char) (ch + DIFF));
            } else {
                output.append(ch);
            }
            previousChar = ch;
        }

        return output.toString();
    }
}
