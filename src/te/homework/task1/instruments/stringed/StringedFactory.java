package te.homework.task1.instruments.stringed;

public final class StringedFactory {
    public static Stringed createBanjo() {
        return new Banjo();
    }

    public static Stringed createHarp() {
        return new Harp();
    }

    public static Stringed createGuitar() {
        return new Guitar();
    }
}
