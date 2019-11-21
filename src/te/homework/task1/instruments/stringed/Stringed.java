package te.homework.task1.instruments.stringed;

import te.homework.task1.instruments.Instrument;

public abstract class Stringed extends Instrument {
    private int strings;

    Stringed(int strings) {
        this.strings = strings;
    }

    public int getStrings() {
        return strings;
    }
}
