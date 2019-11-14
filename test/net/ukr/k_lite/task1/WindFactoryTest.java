package net.ukr.k_lite.task1;

import net.ukr.k_lite.task1.instruments.Instrument;
import net.ukr.k_lite.task1.instruments.wind.WindFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class WindFactoryTest {

    @Test
    public void createAccordion() {
        Instrument instrument = WindFactory.createAccordion();
        assertEquals("Accordion", instrument.getName());
    }

    @Test
    public void createBagpipe() {
        Instrument instrument = WindFactory.createBagpipe();
        assertEquals("Bagpipe", instrument.getName());
    }

    @Test
    public void createDuduk() {
        Instrument instrument = WindFactory.createDuduk();
        assertEquals("Duduk", instrument.getName());
    }
}