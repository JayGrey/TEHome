package te.homework.task1.instruments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Instrument {
    private String name;

    public Instrument() {
        name = this.getClass().getSimpleName();
    }


    public void playMelody(String notes) {
        Matcher matcher = Pattern.compile("[A-F]b|[A-F]#|[A-F]").matcher(notes);
        while (matcher.find()) {
            playNote(matcher.group());
        }
    }

    public void playNote(String note) {
        System.out.print(note);
        System.out.print(' ');
    }

    public String getName() {
        return name;
    }
}
