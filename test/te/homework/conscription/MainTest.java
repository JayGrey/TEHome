package te.homework.conscription;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {


    @Test
    public void test1() {
        Main.Army army = new Main.Army(4, 0, 0);
        army.setOrks(new int[][]{{1, 2, 3, 4}, {2, 1, 4, 3}});

        assertEquals(12, Main.solution(army));

    }

    @Test
    public void test2() {
        Main.Army army = new Main.Army(3, 1, 1);
        army.setOrks(new int[][]{{5, 6, 6}, {5, 7, 8}});

        assertEquals(20, Main.solution(army));
    }

    @Test
    public void test3() {
        Main.Army army = new Main.Army(2, 2, 2);

        assertEquals(-1, Main.solution(army));
    }

    @Test
    public void test4() {
        Main.Army army = new Main.Army(3, 0, 3);
        army.setOrks(new int[][]{{5, 6, 7}, {2, 1, 0}});

        assertEquals(3, Main.solution(army));
    }

    @Test
    public void test5() {
        Main.Army army = new Main.Army(5, 2, 2);
        army.setOrks(new int[][]{{5, 6, 7, 2, 8}, {2, 1, 0, 1, 3}});

        assertEquals(24, Main.solution(army));
    }

}