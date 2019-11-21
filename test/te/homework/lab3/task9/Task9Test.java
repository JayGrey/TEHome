package te.homework.lab3.task9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab 3 task 9")
class Task9Test {

    private Task9 task9;

    @BeforeEach
    void setUp() {
        task9 = new Task9();
    }

    @Test
    void testEn() {
        assertEquals("abc  ghik", task9.removeWordsThatStartWithConsonantChars(3, "abc def ghik"));
        assertEquals(" abc  ghik", task9.removeWordsThatStartWithConsonantChars(3, " abc def ghik"));
        assertEquals("abc  ghik ", task9.removeWordsThatStartWithConsonantChars(3, "abc def ghik "));
        assertEquals(" abc  ghik ", task9.removeWordsThatStartWithConsonantChars(3, " abc def ghik "));

        assertEquals("abc  Ghik", task9.removeWordsThatStartWithConsonantChars(3, "abc Def Ghik"));
        assertEquals(" abc  Ghik", task9.removeWordsThatStartWithConsonantChars(3, " abc Def Ghik"));
        assertEquals("abc  Ghik ", task9.removeWordsThatStartWithConsonantChars(3, "abc Def Ghik "));
        assertEquals(" abc  Ghik ", task9.removeWordsThatStartWithConsonantChars(3, " abc Def Ghik "));

        assertEquals(" Abc  Ghik ", task9.removeWordsThatStartWithConsonantChars(3, " Abc Def Ghik "));
    }

    @Test
    void testRu() {
        assertEquals("абв  жзик", task9.removeWordsThatStartWithConsonantChars(3, "абв где жзик"));
        assertEquals("абв  Жзик", task9.removeWordsThatStartWithConsonantChars(3, "абв Где Жзик"));
        assertEquals("Абв  Жзик", task9.removeWordsThatStartWithConsonantChars(3, "Абв Где Жзик"));
    }
}