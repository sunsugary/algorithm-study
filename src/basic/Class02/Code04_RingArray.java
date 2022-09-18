package basic.Class02;

import java.util.*;

/**
 * @ClassName: Code04_RingArray
 * @Author: 5753
 * @Date: 2022/8/31 9:52
 * @Description: TODO
 */
public class Code04_RingArray {

    //使用数组实现队列
    public static class ArrayQueue<T> {
        //队列当前大小
        private Integer size;

        //push指针
        private Integer pushPoint;

        //pop指针
        private Integer pollPoint;

        //数组
        private ArrayList<T> arr;

        //数组长度
        private final Integer length;

        public ArrayQueue(Integer length) {
            arr = new ArrayList<>();
            this.size = 0;
            this.pushPoint = 0;
            this.pollPoint = 0;
            this.length = length;
        }

        public void push(T value) {
            //先判断size的大小
            if (Objects.equals(size, length)) {
                throw new RuntimeException("队列已经满了！！！");
            }
            //当size比length小
            arr.add(pushPoint, value);
            pushPoint = nextIndex(pushPoint);
            size++;
        }

        public T poll() {
            if (size == 0) {
                throw new RuntimeException("队列为空！！！！");
            }
            T ans = arr.get(pollPoint);
            pollPoint = nextIndex(pollPoint);
            size--;
            return ans;
        }

        private int nextIndex(Integer index) {
            return index < length - 1 ? index + 1 : 0;
        }

        public boolean isEmpty(){
            return size == 0;
        }


    }


    //使用数组实现栈
    public static class ArrayStack<T> {
        //指针
        private Integer index;
        //数组
        private ArrayList<T> arr;

        public ArrayStack() {
            this.index = 0;
            arr = new ArrayList<>();
        }

        public void push(T value) {
            //添加判断arr的长度
            arr.add(index, value);
            index++;
        }

        public T pop() {
            //判断栈中是否还有值
            if (index - 1 < 0) {
                return null;
            }
            return arr.get(--index);
        }

        public boolean isEmpty() {
            return arr.isEmpty();
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


    /**
     * @return void
     * @Author 5753
     * @Description //TODO
     * @Date 9:53 2022/8/31
     * @Param [args]
     **/
    public static void main(String[] args) {
        int testTimes = 10000;
        int maxValue = 1000;
        int oneTestDataNum = 1000;

        System.out.println("test start !!!");
        for (int i = 0; i < testTimes; i++) {
            Stack<Integer> stack = new Stack<>();
            ArrayStack<Integer> myStack = new ArrayStack<>();
            Queue<Integer> queue = new LinkedList<>();
            ArrayQueue<Integer> myQueue = new ArrayQueue<>(oneTestDataNum);

            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * maxValue);
                if (stack.isEmpty()) {
                    stack.push(nums);
                    myStack.push(nums);
                } else if (Math.random() < 0.5) {
                    stack.push(nums);
                    myStack.push(nums);
                } else {
                    if (!isEqual(stack.pop(), myStack.pop())) {
                        System.out.println("Oops!");
                    }
                }

                int numq = (int) (Math.random() * maxValue);
                if(queue.size() == 0){
                    queue.add(numq);
                    myQueue.push(numq);
                } else if (Math.random() < 0.5) {
                    queue.add(numq);
                    myQueue.push(numq);
                }else{
                    if (!isEqual(queue.poll(), myQueue.poll())) {
                        System.out.println("Oops2!!!");
                    }
                }
            }

        }
        System.out.println("test end !!!");


    }
}
