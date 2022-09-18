package basic.Class08;

import java.util.Arrays;

/**
 * @ClassName: Code04_RadixSort
 * @Author: 5753
 * @Date: 2022/9/12 9:52
 * @Description: 基数排序，
 */
public class Code04_RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

        private static void radixSort(int[] arr, int l, int r, int digit) {

        int[] help = new int[r - l + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[10];

            for (int i = l; i <= r; i++) {
                int j = getDigit(arr[i], d);
                count[j]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (int i = r; i >= l; i--) {
                int j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (int i = l, j = 0; i <= r; i++, j++) {
                arr[i] = help[j];
            }
        }
    }
//    public static void radixSort(int[] arr, int L, int R, int digit) {
//        final int radix = 10;
//        int i = 0, j = 0;
//        // 有多少个数准备多少个辅助空间
//        int[] help = new int[R - L + 1];
//        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
//            // 10个空间
//            // count[0] 当前位(d位)是0的数字有多少个
//            // count[1] 当前位(d位)是(0和1)的数字有多少个
//            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
//            // count[i] 当前位(d位)是(0~i)的数字有多少个
//            // 当前d=1 则按照个位上的数字统计这些数字分别在0~9这十个桶中哪一个
//            int[] count = new int[radix]; // count[0..9]
//            for (i = L; i <= R; i++) {
//                // 103  1   3
//                // 209  1   9
//                j = getDigit(arr[i], d);
//                count[j]++;
//            }
//            for (i = 1; i < radix; i++) {
//                count[i] = count[i] + count[i - 1];
//            }
//            for (i = R; i >= L; i--) {
//                j = getDigit(arr[i], d);
//                help[count[j] - 1] = arr[i];
//                count[j]--;
//            }
//            for (i = L, j = 0; i <= R; i++, j++) {
//                arr[i] = help[j];
//            }
//        }
//    }

    private static int getDigit(int num, int d) {
        return ((int) (num / Math.pow(10, d - 1)) % 10);


    }

    //最大值是几位的
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        int ans = 0;
        while (max > 0) {
            max = max / 10;
            ans++;
        }
        return ans;
    }

    public static int[] generateRandomArray(int maxValue, int maxLength) {
        int length = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxValue = 200;
        int maxLength = 6;
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(maxValue, maxLength);
            int[] array2 = new int[array1.length];
            System.arraycopy(array1, 0, array2, 0, array1.length);
            radixSort(array1);
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
