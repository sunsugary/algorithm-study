package begin.Demo03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code02_LinkedListToQueueAndStack {

    /*
     * 链表 跳转结构
     * 单链表的最后一个节点指向空，这个空地址由JVM虚拟机定义
     * 1.用单链表实现队列
     * 2.用单链表实现栈
     */
    /*
    1.队列的重要特点就是先进先出
    2.所以头部是第一个进来的节点
     */

    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
            next = null;
        }
    }

    public static class MyQueue<V> {
        //定义两个变量（指针）分别只想队列的头尾
        private Node<V> head;
        private Node<V> tail;

        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //获取队列的大小
        public int size() {
            return size;
        }


        //队列增加节点
        public void offer(V value) {
            //先将进来的数值变成一个节点
            Node<V> cur = new Node<>(value);

            //判断头节点是否有值
            if (head == null) {
                //说明当前进来的是第一个元素
                head = cur;
                tail = cur;
            } else {
                //将新进来的节点加在尾节点的后面
                tail.next = cur;
                //头节点不用变，将尾节点指向当前节点
                tail = cur;
            }
            size++;
        }

        //队列弹出节点
        public V poll() {
            //从头部开始弹出，并将tail移向下一个节点
            V ans = null;

            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }

            if (head == null) {
                //这一步一定要做，因为当头节点为空的时候，尾节点指向的节点可能并未释放
                tail = null;
            }
            return ans;
        }

        //弹出头节点的值
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    /**
     * 栈是一个弹夹结构，先进后出，移动头节点而尾节点不动
     */
    public static class MyStack<V> {

        //定义两个变量（指针）分别只想队列的头尾
        private Node<V> head;

        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //获取队列的大小
        public int size() {
            return size;
        }

        public void push(V value) {
            Node<V> cur = new Node<>(value);

            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public V pop() {
            V ans = null;

            if (head != null) {
                ans = head.value;
                head = head.next;
            }
            size--;

            return ans;
        }

        public V peek() {
            V ans = null;

            if (head != null) {
                ans = head.value;
            }
            return ans;

        }


    }

    //测试栈 对数器
    public static void testMyStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");

        for (int i = 0; i < testTime; i++) {

            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("错误的栈");
            }

            if (myStack.size() != test.size()) {
                System.out.println("错误的栈");
            }


            double random = Math.random();

            if (random < 0.33) {
                int num = (int) (Math.random() * maxValue);

                myStack.push(num);

                test.push(num);
            } else if (random < 0.66) {
                if (!myStack.isEmpty() && myStack.pop().intValue() != test.pop()) {
                    System.out.println("错误的栈");
                }
            } else {
                if (!myStack.isEmpty() && myStack.peek().intValue() != test.peek()) {
                    System.out.println("错误的栈");
                }
            }
        }

        while (!myStack.isEmpty()) {
            if (myStack.pop().intValue() != test.pop()) {
                System.out.println("错误的栈");
            }

        }
        System.out.println("测试结束");

    }


    //测试队列 对数器
    public static void testMyQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();

        Queue<Integer> queue = new LinkedList<>();

        int testTime = 100;
        int maxValue = 200000000;

        System.out.println("测试开始!");

        for (int i = 0; i < testTime; i++) {
            //两个队列要么同时为空要么同时不为空

            if (myQueue.isEmpty() != queue.isEmpty()) {
                System.out.println("错误的队列1");
            }

            if (myQueue.size != queue.size()) {

                System.out.println("错误的队列2");
            }

            double random = Math.random();

            if (random < 0.33) {
                //往队列中添加节点
                int num = (int) (Math.random() * maxValue);

                myQueue.offer(num);

                queue.offer(num);
            } else if (random < 0.66) {
                //弹出节点
                if (!myQueue.isEmpty()) {
                    if (myQueue.poll().intValue() != queue.poll().intValue()) {
                        System.out.println("错误的队列3");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {

                    if (myQueue.peek().intValue() != queue.peek().intValue()) {

                        System.out.println("错误的队列4");
                    }
                }
            }
        }

        while (!myQueue.isEmpty()) {
            if (myQueue.poll().intValue() != queue.poll().intValue()) {
                System.out.println("错误的队列5");
            }
        }
        System.out.println("测试结束");

    }

    public static void main(String[] args) {
//        testMyQueue();
        testMyStack();
    }


}
