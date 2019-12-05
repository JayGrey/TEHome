package te.homework.task6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Exercise13Test {

    @Test
    void reorderListWithEventArraySize() {
        List<Double> list = Arrays.asList(1.0, 2.0, 3.0, -2.0);

        Exercise13.reorderList(list);

        assertEquals(4, list.size());
        assertEquals(-2.0, list.get(3));

        //
        list = Arrays.asList(1.0, -1.0, -3.0, -2.0);
        Exercise13.reorderList(list);
        assertEquals(4, list.size());
        assertTrue(list.get(0) > 0);

        //
        list = Arrays.asList(-1.0, -1.0, -3.0, 2.0);
        Exercise13.reorderList(list);
        assertEquals(4, list.size());
        assertTrue(list.get(0) > 0);

        //
        list = Arrays.asList(-1.0, 1.0, -3.0, 2.0);
        Exercise13.reorderList(list);
        assertEquals(4, list.size());
        assertTrue(list.get(0) > 0);
        assertTrue(list.get(1) > 0);
        assertTrue(list.get(2) < 0);
        assertTrue(list.get(3) < 0);
    }

    @Test
    void reorderListWithOddArraySize() {
        List<Double> list = Arrays.asList(1.0, 2.0, 3.0);

        Exercise13.reorderList(list);
        assertTrue(list.stream().allMatch(d -> d > 0));

        //
        double[][] data = {
                {1.0, 2.0, -3.0},
                {1.0, -2.0, 3.0},
                {-1.0, 2.0, 3.0},
        };

        for (double[] datum : data) {
            list = Arrays.stream(datum).boxed().collect(Collectors.toCollection(ArrayList::new));
            Exercise13.reorderList(list);
            assertEquals("++-",
                    list.stream().map(d -> d >= 0 ? "+" : "-").collect(Collectors.joining()));
        }
        //
        data = new double[][]{
                {1.0, -2.0, -3.0},
                {-1.0, 2.0, -3.0},
                {-1.0, -2.0, 3.0},
        };

        for (double[] datum : data) {
            list = Arrays.stream(datum).boxed().collect(Collectors.toCollection(ArrayList::new));
            Exercise13.reorderList(list);
            assertEquals("+--",
                    list.stream().map(d -> d >= 0 ? "+" : "-").collect(Collectors.joining()));
        }

        ///
        list = Arrays.asList(-1.0, -2.0, -3.0);

        Exercise13.reorderList(list);
        assertTrue(list.stream().allMatch(d -> d < 0));

        ///
        list = Arrays.asList(1.0, -1.0, -1.0, 1.0, 1.0, -1.0, 1.0);

        Exercise13.reorderList(list);
        assertEquals("++++---",
                list.stream().map(d -> d >= 0 ? "+" : "-").collect(Collectors.joining()));
    }

    @Test
    void testNull() {
        try {
            Exercise13.reorderList(null);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    void testWeirdLists() {
        List<Double> list = new ArrayList<>();
        Exercise13.reorderList(list);
        assertEquals(0, list.size());

        //
        list = Collections.singletonList(1.0);
        Exercise13.reorderList(list);
        assertEquals(1, list.size());
        assertTrue(list.get(0) > 0);

        //
        list = Collections.singletonList(-1.0);
        Exercise13.reorderList(list);
        assertEquals(1, list.size());
        assertTrue(list.get(0) < 0);
    }
}