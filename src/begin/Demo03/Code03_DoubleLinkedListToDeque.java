package begin.Demo03;

import java.util.Deque;
import java.util.LinkedList;

public class Code03_DoubleLinkedListToDeque {
    /**
     * 用双链表实现双端队列
     * 1.双端队列可以从头部加减节点也可以从尾部加减节点
     */
    public static class Node<V> {
        public Node<V> last;
        public Node<V> next;

        public V value;

        public Node(V value) {
            this.value = value;
            last = null;
            next = null;
        }
    }

    public static class MyDQueue<V> {

        private Node<V> head;
        private Node<V> tail;

        private int size;

        public MyDQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }


        public void pushHead(V value) {
            Node<V> cur = new Node<>(value);

            if (head == null) {
                //是第一个节点
                head = cur;
                tail = cur;
            } else {
                //从头部加尾部就不用变
                cur.next = head;
                head.last = cur;
                head = cur;
            }

            size++;

        }

        //在尾部加节点
        public void pushTail(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                //从尾部加，头部不用变
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
            size++;
        }

        //在头部弹出节点
        public V pollHead() {

            V ans = null;

            //如果head为空，则直接返回空
            if (head == null) {

                return ans;
            }

            ans = head.value;
            size--;
            if (head == tail) {
                //如果head等于tail，说明只有一个元素
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        //在尾部弹出节点
        public V pollTail() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            ans = tail.value;
            size--;

            if (head == tail) {

                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }

    }


    public static void testMyDQueue() {
        Deque<Integer> test = new LinkedList<>();
        MyDQueue<Integer> myDQueue = new MyDQueue<>();


        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");

        for (int i = 0; i < testTime; i++) {

            if (test.isEmpty() != myDQueue.isEmpty()) {
                System.out.println("错误的双端队列");
            }

            if (test.size() != myDQueue.size()) {

                System.out.println("错误的双端队列");
            }

            double random = Math.random();

            if (random < 0.33) {
                int num = (int) (Math.random() * maxValue);

                if (Math.random() < 0.5) {
                    myDQueue.pushHead(num);
                    test.addFirst(num);
                } else {
                    myDQueue.pushTail(num);
                    test.addLast(num);
                }
            } else if (random < 0.66) {

                if (!myDQueue.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;

                    if (Math.random() < 0.5) {
                        num1 = myDQueue.pollHead();
                        num2 = test.pollFirst();
                    }else{
                        num1 = myDQueue.pollTail();
                        num2 = test.pollLast();
                    }

                    if (num1 != num2) {
                        System.out.println("错误的双端队列");
                    }
                }



            }else{
                if (!myDQueue.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDQueue.peekHead();
                        num2 = test.peekFirst();
                    }else{
                        num1 = myDQueue.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("错误的双端队列");
                    }
                }


            }

            if (myDQueue.size() != test.size()) {
                System.out.println("Oops!");
            }


        }
        while (!myDQueue.isEmpty()){

            if (myDQueue.pollHead().intValue() != test.pollFirst()) {

                System.out.println("错误的双端队列");
            }

        }
        System.out.println("测试结束！");

    }

    public static void main(String[] args) {
        testMyDQueue();
    }


}
