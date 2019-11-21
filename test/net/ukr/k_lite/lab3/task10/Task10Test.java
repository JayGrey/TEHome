package net.ukr.k_lite.lab3.task10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lab 3 task 10")
class Task10Test {
    private Task10 task10;

    @BeforeEach
    void setUp() {
        task10 = new Task10();
    }

    @Test
    void removeDifferentChars() {
        assertEquals("abc () fgh.", task10.removeChars("abc ( def ) fgh.", '(', ')'));
        assertEquals("abc () ()", task10.removeChars("abc ( def ) (fgh.)", '(', ')'));
        assertEquals("abc () ()  123 ", task10.removeChars("abc ( def ) (fgh.)  123 ", '(', ')'));
        assertEquals("()", task10.removeChars("()", '(', ')'));
    }

    @Test
    void removeIdenticalChars() {
        assertEquals("abc ** fgh.", task10.removeChars("abc *def* fgh.", '*'));
        assertEquals("**", task10.removeChars("**", '*'));
    }

    @Test
    void countWords() {

        assertEquals(3, task10.countWords("abc () fgh."));

        assertEquals(1, task10.countWords("abc"));
        assertEquals(1, task10.countWords(" abc"));
        assertEquals(1, task10.countWords("abc "));
        assertEquals(1, task10.countWords(" abc "));

        assertEquals(0, task10.countWords("  "));
    }

    @Test
    void changeWordSeparator() {
        Task10 task10 = new Task10(new char[]{'.', ',', ' '});

        assertEquals(5, task10.countWords(" abc def,123 jfh.4545 "));

    }
}