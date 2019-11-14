package net.ukr.k_lite.task1;

import net.ukr.k_lite.task1.instruments.stringed.Stringed;
import net.ukr.k_lite.task1.instruments.stringed.StringedFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InstrumentTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }


    @Test
    public void playMelody() {
        Stringed harp = StringedFactory.createHarp();
        harp.playMelody("AB#Cb");

        assertEquals("A B# Cb ", outputStream.toString());
    }

    @Test
    public void playNote() {
        Stringed harp = StringedFactory.createHarp();
        harp.playNote("F");
        assertEquals("F ", outputStream.toString());
    }
}