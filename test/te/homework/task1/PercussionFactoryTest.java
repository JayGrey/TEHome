package te.homework.task1;

import te.homework.task1.instruments.Instrument;
import te.homework.task1.instruments.percussion.PercussionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PercussionFactoryTest {

    @Test
    public void createRandomInstrument() {
        Instrument instrument = PercussionFactory.createRandomInstrument();

        assertNotNull(instrument);
    }

    @Test
    public void createCastanets() {
        Instrument instrument = PercussionFactory.createCastanets();

        assertEquals("Castanets", instrument.getName());
    }

    @Test
    public void createXylophone() {
        Instrument instrument = PercussionFactory.createXylophone();

        assertEquals("Xylophone", instrument.getName());
    }

    @Test
    public void createBongo() {
        Instrument instrument = PercussionFactory.createBongo();

        assertEquals("Bongo", instrument.getName());
    }
}