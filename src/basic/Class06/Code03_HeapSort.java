package basic.Class06;

import java.util.Arrays;

/**
 * @ClassName: Code03_HeapSort
 * @Author: 5753
 * @Date: 2022/9/6 9:14
 * @Description: 堆排序
 */
public class Code03_HeapSort {

    public static class MyHeap {
        private Integer limit;
        private Integer heapSize;
        private int[] heap;

        public MyHeap(Integer limit) {
            this.limit = limit;
            heapSize = 0;
            heap = new int[limit];
        }

        public boolean isFull() {
            return limit == heapSize;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public void push(int num) {
            //判断堆是否满了
            if (heapSize == limit) {
                throw new RuntimeException("heap is full!");
            }
            heap[heapSize] = num;
            heapInsert(heap, heapSize);
            heapSize++;
        }


        public int pop() {
            int ans = heap[0];
            //将要弹出的数与堆的最后一个数进行交换
            swap(heap, 0, --heapSize);
            //交换之后这个数看它的父节点 是否需要再次交换
            heapIfy(heap, heapSize, 0);
            return ans;

        }

        public void heapSoft() {
            if (heap == null || heap.length < 2) {
                return;
            }

            // O(N*logN)
//		    for (int i = 0; i < arr.length; i++) { // O(N)
//			    heapInsert(arr, i); // O(logN)
//		    }
            // O(N)
            //这种方式是用户直接给你一个数组 然后根据这个数组建堆 从下往上建堆，
            //如果正常情况下是一个数一个数的push那就只能从上往下建堆
            // 完全二叉树的深度越大 下边的节点就会越多
            // 所以我们可以先从下面建堆 这样就会节省遍历的次数 从而时间复杂度降低
//            for (int i = arr.length - 1; i >= 0; i--) {
//                heapify(arr, i, arr.length);
//            }

            //因为大根堆每次弹出的节点必然是最大值 每次取0位置换到末尾 (heapSize-1)的位置 然后heapSize - 1 这样就完成了 从小到大的排序
            swap(heap, 0, --heapSize);
            while (heapSize > 0) {
                heapIfy(heap, heapSize, 0);
                swap(heap, 0, --heapSize);
            }
        }

        private void heapIfy(int[] heap, Integer heapSize, int curIndex) {

            //判断是否有子 左节点
            int leftIndex = 2 * curIndex + 1;
            //弹出的数来到了heapSize - 1的位置 原来末尾的数字来到了 0位置
            while (leftIndex < heapSize) {

                int largeIndex = leftIndex + 1 < heapSize ? heap[leftIndex] > heap[leftIndex + 1] ? leftIndex : leftIndex + 1 : leftIndex;

                largeIndex = heap[curIndex] > heap[largeIndex] ? curIndex : largeIndex;

                if (largeIndex == curIndex) {
                    break;
                }

                swap(heap, largeIndex, curIndex);

                curIndex = largeIndex;

                leftIndex = 2 * curIndex + 1;

            }
        }


        private void heapInsert(int[] heap, Integer curIndex) {
            //heapSize 是新进来的数的下标位置
            while (heap[curIndex] > heap[(curIndex - 1) / 2]) {
                //只有当前进来的数比它的父节点大(或者这个数最终来到了 0 index的位置)的时候进行循环
                swap(heap, curIndex, (curIndex - 1) / 2);
                curIndex = (curIndex - 1) / 2;
            }

        }


        public static void swap(int[] arr, int K, int M) {
            int tmp = arr[K];
            arr[K] = arr[M];
            arr[M] = tmp;
        }

    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = new int[arr1.length];
            System.arraycopy(arr1, 0, arr2, 0, arr1.length);

            MyHeap heap = new MyHeap(arr1.length);
            for (int num : arr1) {
                heap.push(num);
            }
            heap.heapSoft();
            arr1 = heap.heap;
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }


}
