package net.ukr.k_lite.lab3.task8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab 3 task 8")
class Task8Test {
    private Task8 task8;

    @BeforeEach
    void setUp() {
        task8 = new Task8();
    }

    @Test
    void removeNonAlphaChars() {
        assertEquals("abcdef ", task8.removeNonAlphaCharsInWords("abc-def (1324)."));
        assertEquals("  abcdef ", task8.removeNonAlphaCharsInWords("  abc-def (1324)."));
        assertEquals("ab cd De ", task8.removeNonAlphaCharsInWords("ab1 cd2 D3e4 ."));
        assertEquals("Привет Мир", task8.removeNonAlphaCharsInWords("Привет, <Мир>!"));
    }

    @Test
    void removeNonAlphaCharsWithOtherDelimiters() {
        Task8 task = new Task8(new char[]{'.'});

        assertEquals("abcdef..", task.removeNonAlphaCharsInWords("abc-def.(1324)."));
        assertEquals("abcdef.", task.removeNonAlphaCharsInWords("  abc-def (1324)."));
        assertEquals("ab.cd.De", task.removeNonAlphaCharsInWords("ab1 .cd2.D3e4 "));
        assertEquals("ПриветМир", task.removeNonAlphaCharsInWords("Привет, <Мир>!"));
    }
}