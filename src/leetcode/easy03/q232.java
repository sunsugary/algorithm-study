package leetcode.easy03;

import java.util.Stack;

/**
 * @ClassName: q232
 * @Author: 5753
 * @Date: 2022/9/25 17:49
 * @Description: TODO
 */
public class q232 {


}

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> help;

    public MyQueue() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        swap();
    }

    public int pop() {
        return help.pop();
    }

    public int peek() {
        return help.peek();
    }

    public boolean empty() {
        return help.size() + stack.size() == 0;
    }

    private void swap() {
        if (help.isEmpty()) {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
    }
}