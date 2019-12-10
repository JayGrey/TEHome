package te.homework.task7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {

    @Test
    void reorderListTrashData() {
        try {
            Exercise1.reorderList(null, 1);
            Exercise1.reorderList(Collections.emptyList(), 1);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    void reorderList() {
        List<Integer> list = Collections.emptyList();
        Exercise1.reorderList(list, 0);
        assertEquals(0, list.size());

        //
        list = Arrays.asList(1, -1);
        Exercise1.reorderList(list, 0);
        assertEquals(2, list.size());
        assertEquals(-1, list.get(0));
        assertEquals(1, list.get(1));

        //
        list = Arrays.asList(3, 1, 2, 3, 4, 6, 7, 0, -3, 4, -7, 11, -11, 23, -16, 10);
        Exercise1.reorderList(list, 10);
        assertTrue(list.get(list.size() - 1) > 10);
        assertTrue(list.get(list.size() - 2) > 10);
        assertTrue(list.get(list.size() - 3) <= 10);

        //
        list = Arrays.asList(3, 1, 2, 3, 4, 6, 7, 0, -3, 4, -7, 11, -11, 23, -16);
        Exercise1.reorderList(list, 10);
        assertTrue(list.get(list.size() - 1) > 10);
        assertTrue(list.get(list.size() - 2) > 10);
        assertTrue(list.get(list.size() - 3) <= 10);
    }
}