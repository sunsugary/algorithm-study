package basic.Class06;

import java.util.Arrays;

/**
 * @ClassName: sortedArrDistanceLessK
 * @Author: 5753
 * @Date: 2022/9/6 14:31
 * @Description: 给一个数组，它是无序的，但是这个数组中的数遵从一个原则，就是每个数最多调整的距离不超过K
 * 从上面这句话中 读出来arr[0]位置上的数必然在0~k位置上 这样取出来0~k位置上的最小值放到 0位置  然后再加入K+1位置上的数 这K个数必然有一个数是在1位置上
 * 我们定义一个小根堆 堆大小最大不超过K 这样数组的顺序加一个弹一个
 */
public class sortedArrDistanceLessK {

    public static class MyHeap {
        private Integer heapSize;
        private int[] heap;

        private Integer limit;

        public MyHeap(Integer limit) {
            this.heapSize = 0;
            this.limit = limit;
            this.heap = new int[limit];
        }


        public boolean isEmpty() {
            return heapSize == 0;
        }

        public void push(int num) {

            //一个数一个数的push只能从上向下的构建堆
            heap[heapSize] = num;
            heapInsert(heap, heapSize);
            heapSize++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("heap is empty!");
            }


            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapIfy(heap, heapSize, 0);
            return ans;
        }

        private void heapIfy(int[] heap, Integer heapSize, int curIndex) {
            int leftIndex = 2 * curIndex + 1;

            while (leftIndex < heapSize) {
                int smallIndex = leftIndex + 1 < heapSize ? heap[leftIndex] < heap[leftIndex + 1] ? leftIndex : leftIndex + 1 : leftIndex;
                smallIndex = heap[smallIndex] < heap[curIndex] ? smallIndex : curIndex;
                if (smallIndex == curIndex) {
                    break;
                }
                swap(heap, smallIndex, curIndex);
                curIndex = smallIndex;
                leftIndex = 2 * curIndex + 1;
            }


        }

        private void heapInsert(int[] heap, Integer curIndex) {
            while (heap[curIndex] < heap[(curIndex - 1) / 2]) {
                swap(heap, curIndex, (curIndex - 1) / 2);
                curIndex = (curIndex - 1) / 2;
            }
        }

        public void swap(int[] arr, int K, int M) {
            int tmp = arr[K];
            arr[K] = arr[M];
            arr[M] = tmp;
        }

    }


    public static void sort(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        // 默认小根堆
        MyHeap heap = new MyHeap(k+1);
        int index = 0;
        // 0...K-1
        for (; index < Math.min(arr.length, heap.limit); index++) {
            heap.push(arr[index]);
        }
        int i = 0;
        while (index < arr.length){
            arr[i++] = heap.pop();
            heap.push(arr[index++]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.pop();
        }
    }


    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int k) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        Arrays.sort(arr);

        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (k + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize, maxValue, k);
            int[] arr1 = new int[arr.length];
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr1, 0, arr.length);
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            sort(arr1, k);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("K : " + k);
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


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
            int minIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            int ans = arr[minIndex];
            arr[minIndex] = arr[--size];
            return ans;
        }

    }


}
