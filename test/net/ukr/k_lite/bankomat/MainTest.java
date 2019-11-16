package net.ukr.k_lite.bankomat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void solution() {
        assertEquals(4, Main.solution(770));
        assertEquals(-1, Main.solution(5));
        assertEquals(-1, Main.solution(15));
    }
}