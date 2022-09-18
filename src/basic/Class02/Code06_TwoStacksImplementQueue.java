package basic.Class02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Code06_TwoStacksImplementQueue
 * @Author: 5753
 * @Date: 2022/9/1 14:35
 * @Description: 如何用栈实现队列结构
 */
public class Code06_TwoStacksImplementQueue {

    //首先用双向链表实现一个栈
    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> last;

        public Node(T value) {
            this.value = value;
            next = null;
            last = null;
        }
    }

    public static class DoubleLinkedStack<T> {
        private Node<T> head;
        private Node<T> tail;

        private Integer size;

        public DoubleLinkedStack() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void pushHead(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

//        public void pushTail(T value) {
//            Node<T> cur = new Node<>(value);
//            if (head == null) {
//                head = cur;
//            } else {
//                tail.next = cur;
//                cur.last = tail;
//            }
//            tail = cur;
//            size++;
//        }


        public T popHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }
            size -- ;
            return cur.value;
        }

//        public T popTail() {
//            if (tail == null) {
//                return null;
//            }
//            Node<T> cur = tail;
//            if (tail == head) {
//                tail = null;
//                head = null;
//            } else {
//                tail = tail.last;
//                cur.last = null;
//                tail.next = null;
//            }
//            return cur.value;
//        }


        public T peekHead(){
            if (head == null) {
                return null;
            }
            return head.value;
        }

        public T peekTail(){
            if (tail == null) {
                return null;
            }
            return tail.value;
        }

    }


    //创建两个栈一个栈为push栈，一个栈为pop栈，
    //当用户需要再队列中poll值的时候，将push栈全部弹出放到pop栈
    //注意只有当pop栈为空的时候才进行倒这个操作，且必须一次性姜push栈中的数据全部倒完
    public static class MyQueue<T> {
        DoubleLinkedStack<T> pushStack;
        DoubleLinkedStack<T> popStack;

        public MyQueue() {
            popStack = new DoubleLinkedStack<>();
            pushStack = new DoubleLinkedStack<>();
        }

        //向队列中添加元素
        public void add(T value) {
            pushStack.pushHead(value);
        }

        //取出队列中的元素
        public T poll(){
            T ans = null;
            pushToPop();
            if (!popStack.isEmpty()){
                ans = popStack.popHead();
            }
            return ans;
        }

        public T peek(){
            T ans = null;
            pushToPop();
            if (!popStack.isEmpty()){
                ans = popStack.peekHead();
            }
            return ans;
        }

        //倒这个操作
        public void pushToPop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.pushHead(pushStack.popHead());
                }
            }

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
        int value = 1000;
        int testTimes = 1000;
        System.out.println("test start!!!");
        for (int i = 0; i < testTimes; i++) {
            MyQueue<Integer> myQueue = new MyQueue<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {

                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    queue.add(numq);
                    myQueue.add(numq);
                } else if (Math.random() < 0.5) {
                    queue.add(numq);
                    myQueue.add(numq);
                }else {
                    if (!isEqual(queue.poll(),myQueue.poll())) {
                        System.out.println("Oops2");
                    }
                }
            }
        }
        System.out.println("test end!!!");
    }

}
