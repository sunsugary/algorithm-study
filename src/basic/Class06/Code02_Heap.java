package basic.Class06;

import java.util.Objects;

/**
 * @ClassName: Code02_Heap
 * @Author: 5753
 * @Date: 2022/9/5 15:33
 * @Description: TODO
 */
public class Code02_Heap {
    //左：2*i+1
    //右：2*i+2
    //父：(i-1)/2
    //堆是完全二叉树 堆分大根堆和小根堆 大根堆是每一颗子树都是根节点最大 小根堆是每一颗子树的根节点小于或等于子节点
    //优先级队列就是堆 默认小根堆

    public static class MyMaxHeap {
        //堆的最大容量
        private Integer limit;
        //堆当前大小
        private Integer heapSize;
        //堆 -> 完全二叉树 -> 数组
        private int[] heap;

        public MyMaxHeap(Integer limit) {
            this.limit = limit;
            heapSize = 0;
            heap = new int[limit];
        }

        public boolean isEmpty() {
            return this.heapSize == 0;
        }

        public boolean isFull() {
            return heapSize.equals(limit);
        }

        public void push(int num) {
            //判断是否堆满了
            if (Objects.equals(heapSize, limit)) {
                throw new RuntimeException("heap is full!");
            }

            //进来的数放在末尾，然后判断它是否需要上浮
            heap[heapSize] = num;
            heapInsert(heap, heapSize);
            heapSize++;

        }

        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapIfy(heap, heapSize, 0);
            return ans;
        }

        private void heapIfy(int[] heap, Integer heapSize, int index) {
            //找到0节点的 子节点 并拿到左右节点中最大节点的位置 将0节点与最大节点的位置进行交换 重复这个操作

            int leftIndex = 2 * index + 1;

            //要注意是否有左节点
            while (leftIndex < heapSize) {
                //如果有右节点 比较左右节点值的大小返回大的index
                int largeIndex = leftIndex + 1 < heapSize ? heap[leftIndex] > heap[leftIndex + 1] ? leftIndex : leftIndex + 1 : leftIndex;

                //拿左右节点中比较大的值和当前值进行比较 返回大值的index
                largeIndex = heap[largeIndex] > heap[index] ? largeIndex : index;
                if (largeIndex == index) {
                    //当大的index 与当前 index相等 则不需要进行下沉
                    break;
                }
                //否则交换夫节点与子节点的值
                swap(heap, largeIndex, index);
                index = largeIndex;
                leftIndex = 2 * index + 1;
            }


        }

        private void heapInsert(int[] heap, Integer heapSize) {
            //找到父节点 比较当前插入的数是否比他父亲节点大 如果大则交换或者到0位置 重复这个操作
            while (heap[heapSize] > heap[(heapSize - 1) / 2]) {
                swap(heap, heapSize, (heapSize - 1) / 2);
                heapSize = (heapSize - 1) / 2;
            }
        }

        public void swap(int[] arr, int K, int M) {
            int tmp = arr[K];
            arr[K] = arr[M];
            arr[M] = tmp;
        }


    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }


    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
