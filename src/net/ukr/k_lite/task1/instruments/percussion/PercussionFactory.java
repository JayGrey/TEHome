package net.ukr.k_lite.task1.instruments.percussion;


import java.util.Random;

public final class PercussionFactory {
    private PercussionFactory() {
    }

    public static Percussion createRandomInstrument() {
        Random random = new Random();

        switch (random.nextInt(3)) {
            case 0: {
                return createBongo();
            }
            case 1: {
                return createCastanets();
            }

            case 2: {
                return createXylophone();
            }

            default: {
                throw new RuntimeException("Random number out of range: %d");
            }
        }
    }

    public static Percussion createCastanets() {
        return new Castanets();
    }

    public static Percussion createXylophone() {
        return new Xylophone();
    }

    public static Percussion createBongo() {
        return new Bongo();
    }
}
