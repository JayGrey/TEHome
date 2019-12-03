package te.homework.task4.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class VarTest {

    @Test
    void illegalArguments() {

        try {
            Var.of(null, 1);
            fail();
        } catch (IllegalArgumentException ignore) {
        }

        try {
            Var.of("x", 0);
            fail();
        } catch (IllegalArgumentException ignore) {
        }

        assertEquals(1, Var.of("x").power);
    }

    @Test
    void equals() {
        assertEquals(Var.of("x", 1), Var.of("x", 1));
        assertEquals(Var.of("x", 1), Var.of("x", 2));
        assertNotEquals(Var.of("x", 1), Var.of("X", 1));
    }

    @Test
    void testToString() {
        assertEquals("x", Var.of("x").toString());
        assertEquals("x", Var.of("x", 1).toString());
        assertEquals("x^2", Var.of("x", 2).toString());
    }
}