package te.homework.lab3.task2;


import te.homework.lab3.Task;

class Task2 extends Task {

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

}
