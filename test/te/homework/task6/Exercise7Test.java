package te.homework.task6;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class Exercise7Test {

    @Test
    void swapStacks() {
        Deque<String> stack1 = new ArrayDeque<>(Arrays.asList("1", "2", "3"));
        Deque<String> stack2 = new ArrayDeque<>(Arrays.asList("a", "b", "c"));
        Exercise7.swapStacks(stack1, stack2);

        assertArrayEquals(new String[]{"a", "b", "c"}, stack1.toArray(new String[0]));
        assertArrayEquals(new String[]{"1", "2", "3"}, stack2.toArray(new String[0]));
    }

    @Test
    void checkEmptyStack() {
        //
        Deque<String> stack1 = new ArrayDeque<>(Arrays.asList("1", "2", "3"));
        Deque<String> stack2 = new ArrayDeque<>();
        Exercise7.swapStacks(stack1, stack2);

        assertEquals(0, stack1.size());
        assertArrayEquals(new String[]{"1", "2", "3"}, stack2.toArray(new String[0]));

        //
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>(Arrays.asList("1", "2", "3"));
        Exercise7.swapStacks(stack1, stack2);

        assertArrayEquals(new String[]{"1", "2", "3"}, stack1.toArray(new String[0]));
        assertEquals(0, stack2.size());

        //
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        Exercise7.swapStacks(stack1, stack2);

        assertEquals(0, stack1.size());
        assertEquals(0, stack2.size());
    }

    @Test
    void checkNull() {
        Deque<String> stack = new ArrayDeque<>(Arrays.asList("a", "b", "c"));

        //

        try {
            Exercise7.swapStacks(null, stack);
            fail();
        } catch (IllegalArgumentException ignored) {

        }

        //

        try {
            Exercise7.swapStacks(stack, null);
            fail();
        } catch (IllegalArgumentException ignored) {

        }

        //

        try {
            Exercise7.swapStacks(null, null);
            fail();
        } catch (IllegalArgumentException ignored) {

        }
    }
}