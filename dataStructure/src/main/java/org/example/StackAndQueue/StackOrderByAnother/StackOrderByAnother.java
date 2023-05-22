package org.example.StackAndQueue.StackOrderByAnother;

import java.util.Stack;
/*
一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一
个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构
 */
public class StackOrderByAnother {
    /**
     *
     *原栈为stack,辅助栈为help,stack.pop为cur
     * --  cur <= help.peek,cur直接压入help
     * --  cur > help.peek,help元素逐一弹出,逐一压入stack,直到cur <= help.peek,再将cur压入help
     * --  stack全部压入到help后,将help所有元素逐一压入stack完成排序
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
