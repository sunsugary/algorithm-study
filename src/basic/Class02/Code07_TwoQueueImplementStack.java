package basic.Class02;

import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName: Code07_TwoQueueImplementStack
 * @Author: 5753
 * @Date: 2022/9/1 17:00
 * @Description: 如何用队列实现栈结构
 */
public class Code07_TwoQueueImplementStack {

    //先用数组实现一个队列
    public static class ArrayQueue {
        private Integer pushPoint;
        private Integer pollPoint;
        private Integer length;
        private Integer size;

        private Integer[] arr;

        public ArrayQueue(Integer length) {
            this.length = length;
            this.size = 0;
            this.pushPoint = 0;
            this.pollPoint = 0;
            arr = new Integer[length];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(Integer value) {
            if (Objects.equals(size, length)) {
                throw new RuntimeException("队列已经满了！！");
            }
            size++;
            arr[pushPoint] = value;
            pushPoint = nextIndex(pushPoint);
        }

        public Integer poll() {
            if (isEmpty()) {
                throw new RuntimeException("队列已经空了！！");
            }
            size--;
            Integer ans = arr[pollPoint];
            pollPoint = nextIndex(pollPoint);
            return ans;
        }

        public Integer peek() {
            if (isEmpty()) {
                throw new RuntimeException("队列已经空了！！");
            }
            return arr[pollPoint];
        }

        public Integer nextIndex(Integer index) {
            return index < length - 1 ? index + 1 : 0;
        }

    }

    public static class MyStack {
        private ArrayQueue queue;
        private ArrayQueue help;


        public MyStack(Integer length) {
            this.queue = new ArrayQueue(length);
            this.help = new ArrayQueue(length);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }


        public void push(Integer value) {
            queue.push(value);
        }

        public Integer pop() {
            while (queue.size > 1) {
                help.push(queue.poll());
            }
            Integer ans = queue.poll();
            ArrayQueue temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        private void swap(ArrayQueue queue, ArrayQueue help) {
            ArrayQueue temp = queue;
            queue = help;
            help = temp;
        }

        public Integer peek() {
            while (queue.size > 1) {
                help.push(queue.poll());
            }
            Integer ans = queue.poll();
            help.push(ans);
            ArrayQueue temp = queue;
            queue = help;
            help = temp;
            return ans;
        }


    }

    private static void test() {
        System.out.println("test begin");
        MyStack myStack = new MyStack(1000000);
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.pop().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");
    }


    public static boolean isEqual(Integer o1, Integer o2) {

        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }

        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

}
