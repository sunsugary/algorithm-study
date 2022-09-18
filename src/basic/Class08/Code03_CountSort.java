package basic.Class08;

import java.util.Arrays;

/**
 * @ClassName: Code03_CountSort
 * @Author: 5753
 * @Date: 2022/9/12 9:31
 * @Description: 计数排序，找到数组中最大值，然后定义一个辅助数组，遍历原数组，将数插入到辅助数组对应下标
 */
public class Code03_CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        int[] help = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }


    public static int[] generateRandomArray(int maxValue, int maxLength) {
        int length = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxValue = 200;
        int maxLength = 250;
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(maxValue, maxLength);
            int[] array2 = new int[array1.length];
            System.arraycopy(array1, 0, array2, 0, array1.length);
            countSort(array1);
            Arrays.sort(array2);
            for (int j = 0; j < array1.length; j++) {
                if (array1[j] != array2[j]) {
                    System.out.println("出错了！");
                    printArray(array1);
                    printArray(array2);
                }
            }
        }
    }

}
