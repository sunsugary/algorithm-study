package basic.Class01;

public class Code06_BSAwesome {
    /**
     * 找出局部最小
     * 1.给定一个数组，数组无序，但是相邻两个数不会相等
     * 2.找出一个局部最小，也就是找一个谷底
     */
    public static int getLessIndex(int[] arr) {
        //首先判断数组的两端是否为局部最小
        if (arr.length == 1) {
            return 0;
        }

        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }


        int L = 1;
        int R = arr.length - 2;
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (arr[mid - 1] < arr[mid]) {
                R = mid - 1;
            } else if (arr[mid - 1] > arr[mid]) {
                L = mid + 1;
            } else {
                //mid位置不大于左边也不大于右边，则mid就是谷底
                return mid;
            }
        }
        return L;

    }
}
