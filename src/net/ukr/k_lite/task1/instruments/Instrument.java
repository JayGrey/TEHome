package net.ukr.k_lite.task1.instruments;

public abstract class Instrument {
    private String name;

    public Instrument() {
        name = this.getClass().getSimpleName();
    }


    //todo: C C#
    public void playMelody(String notes) {
        for (String note : notes.split("")) {
            playNote(note);
        }
    }

    public void playNote(String note) {
        System.out.print(note);
    }

    public String getName() {
        return name;
    }
}
