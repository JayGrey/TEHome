package net.ukr.k_lite.lab3task2;


public class Task2 {

    int getCharPos(int ch) {
        final int EN_FIRST_UPPER = 0x41;
        final int EN_LAST_UPPER = 0X5A;

        if ((Character.toUpperCase(ch) >= EN_FIRST_UPPER)
                && (Character.toUpperCase(ch) <= EN_LAST_UPPER)
        ) {
            return Character.toUpperCase(ch) - EN_FIRST_UPPER + 1;
        }

        final int RU_FIRST_UPPER = 0x410;
        final int RU_LAST_UPPER = 0X42F;

        if ((Character.toUpperCase(ch) >= RU_FIRST_UPPER)
                && (Character.toUpperCase(ch) <= RU_LAST_UPPER)
        ) {
            return Character.toUpperCase(ch) - RU_FIRST_UPPER + 1;
        }

        return 0;
    }

    int[] getCharsPos(String input) {
        return input.chars().map(this::getCharPos).toArray();
    }

    public int[] process(String input) {
        return new int[0];
    }
}
