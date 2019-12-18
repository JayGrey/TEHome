package te.homework.eval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateTest {

    @Test
    void eval() {
        assertEquals(2.0, new Evaluate().eval("1 + 1"));
        assertEquals(6.0, new Evaluate().eval("2 + 2 * 2"));
        assertEquals(5.0, new Evaluate().eval("2 + 2 * 2 - 1"));
        assertEquals(3.0, new Evaluate().eval("2 + 2 * 2 - 6/2"));
        assertEquals(2.0, new Evaluate().eval("2"));
    }

    @Test
    void evalWithBraces() {
        assertEquals(8.0, new Evaluate().eval(" (2 + 2 ) * 2"));

    }
}