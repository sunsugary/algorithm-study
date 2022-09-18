package basic.Class02;

/**
 * @ClassName: Code05_GetMinStack
 * @Author: 5753
 * @Date: 2022/8/31 15:14
 * @Description: TODO
 */
public class Code05_GetMinStack<T> {
    //5.实现一个特殊的栈，满足基本的功能外，再实现返回栈中最小值的功能，并且要求push，pop，get Min方法都是O（1）


    //用单链表实现一个栈
    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class MyStack<T> {
        private Node<T> head;
        private Integer size;

        public MyStack() {
            this.size = 0;
            head = null;
        }

        public Integer size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(T value) {
            Node<T> cur = new Node<>(value);
            if (head != null) {
                cur.next = head;
            }
            head = cur;
            size++;
        }

        public T poll() {
            if (head == null) {
                return null;
            }

            T ans = head.value;
            head = head.next;
            size--;
            return ans;

        }

        public T peek(){
            if (head == null) {
                return null;
            }

            return head.value;
        }

    }

    public static class MinStack{
        private MyStack<Integer> dataStack;
        private MyStack<Integer> minStack;

        public MinStack() {
            dataStack = new MyStack<>();
            minStack = new MyStack<>();
        }

        public void push(int value){
            if (minStack.isEmpty()) {
                minStack.push(value);
            } else if (value < minStack.peek()) {
                minStack.push(value);
            }else {
                minStack.push(minStack.peek());
            }
            dataStack.push(value);
        }

        public Integer pop(){
            if (dataStack.isEmpty()){
                throw new RuntimeException("栈内已经没有数据啦！");
            }
            minStack.poll();
            return dataStack.poll();
        }

        public Integer getMin(){
            if (minStack.isEmpty()){
                throw new RuntimeException("栈内已经没有数据啦！");
            }
            return minStack.peek();
        }


    }

    public static void main(String[] args) {

        MinStack stack2 = new MinStack();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }




}
