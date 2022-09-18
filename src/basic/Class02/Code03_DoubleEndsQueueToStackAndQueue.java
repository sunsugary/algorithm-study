package basic.Class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code03_DoubleEndsQueueToStackAndQueue {
    /**
     * 2.使用双向链表实现队列
     * 队列的结构是先进先出
     */

    public static class DoubleNode<T> {
        private T value;
        private DoubleNode<T> next;
        private DoubleNode<T> last;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T> {
        public DoubleNode<T> head;
        public DoubleNode<T> tail;

        public void addFromHead(T value) {
            DoubleNode<T> cur = new DoubleNode<T>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromTail(T value) {

            DoubleNode<T> cur = new DoubleNode<T>(value);

            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
        }

        //从头部弹出
        public T popFromHead() {
            if (head == null) {
                return null;
            }
            DoubleNode<T> cur = head;

            if (head == tail) {
                //说明只有一个节点
                head = null;
                tail = null;
            } else {
                head = head.next;
                //释放cur
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        //从尾部弹出
        public T popFromTail() {
            if (tail == null) {
                return null;
            }
            DoubleNode<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }

    public static class MyQueue<T> {
        public DoubleEndsQueue<T> queue;

        public MyQueue() {
            this.queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyStack<T> {
        public DoubleEndsQueue<T> stack;

        public MyStack() {
            this.stack = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            stack.addFromTail(value);
        }

        public T pop() {
            return stack.popFromTail();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }


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


    public static void main(String[] args) {

        int oneTestDataNum = 1000;
        int value = 10000;
        int testTimes = 100000;
        System.out.println("test start!!!");
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < oneTestDataNum; j++) {

                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    stack.push(nums);
                    myStack.push(nums);
                } else if (Math.random() < 0.5) {
                    stack.push(nums);
                    myStack.push(nums);
                } else {
                    if (!isEqual(stack.pop(), myStack.pop())) {
                        System.out.println("Oops1");
                    }
                }

                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    queue.add(numq);
                    myQueue.push(numq);
                } else if (Math.random() < 0.5) {
                    queue.add(numq);
                    myQueue.push(numq);
                }else {
                    if (!isEqual(queue.poll(),myQueue.pop())) {
                        System.out.println("Oops2");
                    }
                }


            }


        }
        System.out.println("test end!!!");
    }


}
