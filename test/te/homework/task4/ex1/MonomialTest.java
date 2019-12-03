package te.homework.task4.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    @Test
    void of() {
        Monomial monomial = Monomial.of(1, Var.of("x"), Var.of("y"));
        assertNotNull(monomial);

        assertEquals(2, monomial.variables.size());

        //
        Monomial monomial2 = Monomial.of(1, Var.of("x"), Var.of("x"));
        assertEquals(1, monomial2.variables.size());

        //
        Monomial monomial3 = Monomial.of(2, Var.of("x", 2), Var.of("x", 3));
        assertEquals(1, monomial3.variables.size());
        assertEquals(2, monomial3.variables.get("x"));

        //
        try {
            Monomial.of(1, (Var[]) null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        //
        assertTrue(Monomial.of(0, Var.of("x")).isZero);

        //
        assertTrue(Monomial.of(1e-9, Var.of("x")).isZero);

        //
        try {
            Monomial.of(Double.NaN);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        //
        try {
            Monomial.of(Double.POSITIVE_INFINITY);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void testToString() {
        assertEquals("2.0000xy^2z^3",
                Monomial.of(2, Var.of("y", 2), Var.of("x"), Var.of("z", 3)).toString());

        assertEquals("", Monomial.of(0).toString());
    }

    @Test
    void testEquals() {
        Monomial expected = Monomial.of(2, Var.of("y"), Var.of("x"));
        assertEquals(expected, Monomial.of(2, Var.of("x"), Var.of("y")));

        assertNotEquals(expected, Monomial.of(2, Var.of("x", 2), Var.of("y")));

        assertNotEquals(expected,
                Monomial.of(2, Var.of("x"), Var.of("y"), Var.of("z")));

        assertNotEquals(expected, Monomial.of(3, Var.of("x"), Var.of("y")));
    }

    @Test
    void multiply() {
        Monomial expected = Monomial.of(6, Var.of("x"), Var.of("y"));

        assertEquals(expected,
                Monomial.of(3, Var.of("x")).multiply(Monomial.of(2, Var.of("y"))));

        //
        expected = Monomial.of(-6, Var.of("x", 2), Var.of("y", 3), Var.of("z"));

        assertEquals(expected,
                Monomial.of(3, Var.of("x"), Var.of("y", 2)).multiply(
                        Monomial.of(-2, Var.of("x"), Var.of("y"), Var.of("z"))));
        //
        try {
            expected.multiply(null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        //
        assertTrue(expected.multiply(Monomial.of(0, Var.of("x"))).isZero);

        //
        assertTrue(Monomial.of(0).multiply(Monomial.of(1)).isZero);

    }

    @Test
    void testAddSimilar() {
        Monomial expected = Monomial.of(5, Var.of("x"));
        assertEquals(expected, Monomial.of(2, Var.of("x")).addSimilar(Monomial.of(3, Var.of("x"))));
    }
}