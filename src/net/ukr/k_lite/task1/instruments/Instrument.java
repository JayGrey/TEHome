package net.ukr.k_lite.task1.instruments;

import java.util.Arrays;

public abstract class Instrument {
    private String name;

    public Instrument() {
        name = this.getClass().getSimpleName();
    }


    public void playMelody(String notes) {

        String acceptableNotes = "CDEFGAB#b";
        Arrays.stream(notes.split("")).filter(acceptableNotes::contains).forEach(this::playNote);
    }


    // C D E F G A B # b
    public void playNote(String note) {
        System.out.print(note);
    }

    public String getName() {
        return name;
    }
}
