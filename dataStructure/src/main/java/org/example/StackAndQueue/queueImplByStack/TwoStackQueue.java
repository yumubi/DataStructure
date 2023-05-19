package org.example.StackAndQueue.queueImplByStack;

import java.util.Stack;

public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }


    /*
    push栈向pop栈倒入数据
    1.如果 stackPop 不为空，stackPush 绝对不能向 stackPop 中压入数据。
    2.如果 stackPush 要往 stackPop 中压入数据，那么必须一次性把 stackPush 中的数据全部压入
    调用 add、poll 和 peek 三种方法中的任何一种时发生“压”入数据的行为都是可以的
压入
     */
    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

}
