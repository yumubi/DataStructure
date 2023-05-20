package org.example.StackAndQueue.RecursionStack;

import java.util.Stack;

public class InverseOrder {
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
