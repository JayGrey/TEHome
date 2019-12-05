package te.homework.bankomat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void solution() {
        assertEquals(4, Main.solution(770));
        assertEquals(-1, Main.solution(5));
        assertEquals(-1, Main.solution(15));
    }
}