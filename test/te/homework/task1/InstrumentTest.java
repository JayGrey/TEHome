package te.homework.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import te.homework.task1.instruments.stringed.Stringed;
import te.homework.task1.instruments.stringed.StringedFactory;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstrumentTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalStream = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
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