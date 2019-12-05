package te.homework.task6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/*
 Задать два стека, поменять информацию местами.
* */

public class Main7 {
    public static void main(String[] args) {
        Deque<String> stack1 = new ArrayDeque<>(Arrays.asList("1", "2", "3"));
        Deque<String> stack2 = new ArrayDeque<>(Arrays.asList("a", "b", "c"));

        System.out.println("stack 1 before: " + stack1);
        System.out.println("stack 2 before: " + stack2);

        Exercise7.swapStacks(stack1, stack2);
        System.out.println("stack 1 after: " + stack1);
        System.out.println("stack 2 after: " + stack2);
    }
}
