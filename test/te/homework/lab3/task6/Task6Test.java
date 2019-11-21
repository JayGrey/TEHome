package te.homework.lab3.task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab 3 task 6")
class Task6Test {
    private Task6 task6;

    @BeforeEach
    void setUp() {
        task6 = new Task6();
    }

    @Test
    void isDelimiter() {
        assertTrue(task6.isDelimiter(' '));
        assertFalse(task6.isDelimiter('a'));
    }

    @Test
    void testNonDefaultDelimiter() {
        Task6 task = new Task6(new char[]{' ', ',', '.'});
        assertTrue(task.isDelimiter(' '));
        assertTrue(task.isDelimiter('.'));
        assertTrue(task.isDelimiter(','));
        assertFalse(task.isDelimiter('a'));
    }


    @Test
    void insertAfter() {
        String s = "bc";
        String t = "1234";
        String actual = "Abcd adfbc a bc bcada dfere dgbc";
        String expected = "Abcd adfbc1234 a bc1234 bcada dfere dgbc1234";

        assertEquals(expected, task6.insertAfter(s, t, actual));
    }

    @Test
    void insertAfterWithOtherDelimiter() {
        Task6 task = new Task6(new char[]{' ', ',', '.'});

        String s = "bc";
        String t = "1234";
        String actual = "Abcd adfbc, a bc bcada. Dfere dgbc";
        String expected = "Abcd adfbc1234, a bc1234 bcada. Dfere dgbc1234";

        assertEquals(expected, task.insertAfter(s, t, actual));
    }

    @Test
    void insertAfter1() {
        assertEquals("abcdeXX", task6.insertAfter("de", "XX", "abcde"));
        assertEquals(" abcdeXX", task6.insertAfter("de", "XX", " abcde"));
        assertEquals(" abcdeXX ", task6.insertAfter("de", "XX", " abcde "));
        assertEquals("abcdeXX ", task6.insertAfter("de", "XX", "abcde "));
        assertEquals("", task6.insertAfter("de", "XX", ""));
        assertEquals("   ", task6.insertAfter("de", "XX", "   "));
        assertEquals(" abcXX defXX ", task6.insertAfter("", "XX", " abc def "));
        assertEquals(" abcz defz ", task6.insertAfter("z", "", " abcz defz "));
    }

    @Test
    void insertAfterWithDifferentDelimiters() {
        Task6 task = new Task6(new char[]{' ', ',', '.'});
        assertEquals("abcdeXX", task.insertAfter("de", "XX", "abcde"));
        assertEquals(" abcdeXX", task.insertAfter("de", "XX", " abcde"));
        assertEquals(",abcdeXX.", task.insertAfter("de", "XX", ",abcde."));
        assertEquals("abcdeXX.", task.insertAfter("de", "XX", "abcde."));
        assertEquals("", task.insertAfter("de", "XX", ""));
        assertEquals(",. ", task.insertAfter("de", "XX", ",. "));
        assertEquals(" abcXX.defXX ", task.insertAfter("", "XX", " abc.def "));
        assertEquals(" abcz,defz ", task.insertAfter("z", "", " abcz,defz "));
    }
}