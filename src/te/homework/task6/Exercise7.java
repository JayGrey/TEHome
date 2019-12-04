package te.homework.task6;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 Задать два стека, поменять информацию местами.
* */
public interface Exercise7 {
    static <T> void swapStacks(Deque<T> stack1, Deque<T> stack2) {
        if (stack1 == null || stack2 == null) {
            throw new IllegalArgumentException();
        }

        Deque<T> tempDeque = new ArrayDeque<>(stack1.size() + stack2.size());

        int stack2Size = stack2.size();

        while (stack1.peek() != null) {
            tempDeque.push(stack1.pop());
        }

        while (stack2.peek() != null) {
            tempDeque.push(stack2.pop());
        }

        while (stack2Size > 0) {
            stack1.push(tempDeque.pop());
            stack2Size -= 1;
        }

        while (tempDeque.peek() != null) {
            stack2.push(tempDeque.pop());
        }
    }
}
