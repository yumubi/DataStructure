package org.example.StackAndQueue.RecursionStack;

import java.util.Stack;

/**
 * 实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构
 */
public class InverseOrder {

    /**
     * 将栈 stack 的栈底元素返回并移除。
     *
     * 栈队列3->2->1变为1(pop出来了), 2->3
     * @param stack
     * @return
     */
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

    /**
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }


}
