package leetcode.easy03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 用队列实现栈
 * @Author: 5753
 * @Date: 2022/9/25 14:31
 * @Description: TODO
 */
public class q225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.pop();
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }


}

class MyStack {
    Queue<Integer> queue;
    Queue<Integer> help;
    public MyStack() {
        help = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while (size > 1){
            help.offer(queue.poll());
            size--;
        }
        int ans = queue.poll();
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
        return ans;
    }

    public int top() {
        int t = queue.size();
        while (t > 1){
            help.offer(queue.poll());
            t--;
        }
        int ans = queue.poll();
        help.offer(ans);
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
        return ans;
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}

class MyStack2 {
    Queue<Integer> queue;
    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

