package te.homework.task1;

import te.homework.task1.instruments.stringed.Stringed;
import te.homework.task1.instruments.stringed.StringedFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringedFactoryTest {

    @Test
    public void createBanjo() {
        Stringed instrument = StringedFactory.createBanjo();

        assertEquals("Banjo", instrument.getName());
        assertEquals(5, instrument.getStrings());
    }

    @Test
    public void createHarp() {
        Stringed instrument = StringedFactory.createHarp();

        assertEquals("Harp", instrument.getName());
        assertEquals(47, instrument.getStrings());

    }

    @Test
    public void createGuitar() {
        Stringed instrument = StringedFactory.createGuitar();

        assertEquals("Guitar", instrument.getName());
        assertEquals(6, instrument.getStrings());
    }
}