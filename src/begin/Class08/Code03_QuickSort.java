package begin.Class08;

import java.util.Arrays;

public class Code03_QuickSort {

    //快排

    /**
     * 原理是，先定义数组最后一个数（P）为比较值，数组中所有的数都和P进行比较
     * 当比P小的时候，将这个数放在左边，当比P大的时候放在右边，等于的放在中间
     * 然后返回小于区的左右index，这时候根据小于区左右index,将左边的数组，和右边的数组调用递归，最终顺序
     */

    public static void quickSort1(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    public static void process(int arr[], int L, int R) {
        if (L >= R) {
            return;
        }
        //等于区的左右坐标
        int[] partition = partition(arr, L, R);

        process(arr, L, partition[0] - 1);
        process(arr, partition[1] + 1, R);
    }


    public static int[] partition(int[] arr, int L, int R) {
        //小于区的右边界
        int lessR = L - 1;
        //当前数索引
        int index = L;
        //大于区的左边界
        int moreL = R;

        //直到index来到大于区的左边界

        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, index, lessR + 1);
                lessR++;
                index++;
            } else if (arr[index] > arr[R]) {
                swap(arr, index, moreL - 1);
                moreL--;
                //大于的时候index不用加的，因为换过来的数并未进行比较
            } else {
                index++;
            }
        }

        //最后需要将arr数组的最后一个值也就是P 和大于区的第一个值进行交换
        swap(arr, R, moreL);
        //最终返回等于区的左右边界
        return new int[]{lessR + 1, moreL};

    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[(int) ((100 + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((100 + 1) * Math.random()) - (int) (100 * Math.random());
        }



        quickSort1(arr);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
