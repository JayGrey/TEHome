package te.homework.eval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateTest {

    @Test
    void eval() {
        assertEquals(2.0, new Evaluate().eval("1 + 1"));
        assertEquals(-2.0, new Evaluate().eval("1 - 3"));
        assertEquals(6.0, new Evaluate().eval("2 + 2 * 2"));
        assertEquals(5.0, new Evaluate().eval("2 + 2 * 2 - 1"));
        assertEquals(3.0, new Evaluate().eval("2 + 2 * 2 - 6/2"));
        assertEquals(2.0, new Evaluate().eval("2"));
    }


    @Test
    void evalWithNegativeNumbers() {
        assertEquals(0, new Evaluate().eval("-2 + 2"));
        assertEquals(0, new Evaluate().eval("2 + -2"));
    }

    @Test
    void evalNumbersWithFractions() {
        assertEquals(3.0, new Evaluate().eval("1.5 + 1.5"));
        assertEquals(0.0, new Evaluate().eval("1.5 + -1.5"));
        assertEquals(0.0, new Evaluate().eval("+1.5 - +1.5"));
        assertEquals(2.0, new Evaluate().eval("1.5 + 0.5"));
        assertEquals(2.0, new Evaluate().eval("1.5 + .5"));
        assertEquals(6.5, new Evaluate().eval("1.5 + 5."));
    }

    @Test
    void evalWithBraces() {
        assertEquals(8.0, new Evaluate().eval(" (2 + 2 ) * 2"));
        assertEquals(8.0, new Evaluate().eval(" 2* (2 + 2 ) "));
        assertEquals(4.0, new Evaluate().eval(" 2* (2 + 6 ) / 4"));
        assertEquals(10.0, new Evaluate().eval("(10)"));
        assertEquals(10.0, new Evaluate().eval("2 + (8)"));
        assertEquals(10.0, new Evaluate().eval("2 + (8)"));
        assertEquals(15.0, new Evaluate().eval("1 + (2 + (3 * 4))"));
        assertEquals(10.0, new Evaluate().eval("(1 + 2) * (3 + 4) - ( 5 + 6)"));
    }
}
