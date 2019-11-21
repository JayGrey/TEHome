package net.ukr.k_lite.lab3task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lab 3 task 5")
class Task5Test {
    private Task5 task5;

    @BeforeEach
    void setUp() {
        task5 = new Task5();
    }

    @Test
    void insertWord() {
        assertEquals("abc1234def", task5.insertWord("1234", 3, "abcdef"));
        assertEquals(" abc1234def", task5.insertWord("1234", 3, " abcdef"));
        assertEquals("abc1234def ", task5.insertWord("1234", 3, "abcdef "));
        assertEquals("abc1234", task5.insertWord("1234", 3, "abc"));
        assertEquals("ab cd ef", task5.insertWord("1234", 3, "ab cd ef"));
        assertEquals("ab cd efg1234h", task5.insertWord("1234", 3, "ab cd efgh"));
    }

    @Test
    void countWords() {
        assertEquals(1, task5.countWords("abc"));
        assertEquals(1, task5.countWords(" abc"));
        assertEquals(1, task5.countWords("abc "));
        assertEquals(1, task5.countWords(" abc "));

        assertEquals(0, task5.countWords(" "));

        assertEquals(4, task5.countWords("abcd abc   fd  1234"));
    }

    @Test
    void insertWordWithOtherSeparator() {
        Task5 task5 = new Task5(new char[]{',', '.', ' '});
        assertEquals("abc1234def", task5.insertWord("1234", 3, "abcdef"));
        assertEquals(".abc1234def", task5.insertWord("1234", 3, ".abcdef"));
        assertEquals("abc1234def, .", task5.insertWord("1234", 3, "abcdef, ."));
        assertEquals("abc1234", task5.insertWord("1234", 3, "abc"));
        assertEquals("ab, cd. Ef", task5.insertWord("1234", 3, "ab, cd. Ef"));
        assertEquals("ab,cd efg1234h", task5.insertWord("1234", 3, "ab,cd efgh"));
    }

    @Test
    void countWordsWithOtherSeparator() {
        Task5 task5 = new Task5(new char[]{',', '.', ' '});
        assertEquals(1, task5.countWords("abc"));
        assertEquals(1, task5.countWords(",abc"));
        assertEquals(1, task5.countWords("abc."));
        assertEquals(1, task5.countWords(" abc ,"));

        assertEquals(0, task5.countWords("  ,,, .. , "));

        assertEquals(4, task5.countWords("abcd abc  , fd  1234.., "));
    }
}