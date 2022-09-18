package begin.Demo02;

/**
 * 选择排序
 */
public class Code03 {

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;

    }

    /**
     * 先想边界条件 为空 或者 长度为1
     * 我先从
     * 0 ~ n-1 找最小放到0
     * 1 ~ n-1 找最小放到1
     * 2 ~ n-1 找最小放到2
     * n ~ n-1 找最小放到n
     *
     * @param a
     * @return
     */
    private static void selectSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            /**
             * 0 ~ n-1 找最小放到0
             * 1 ~ n-1 找最小放到1
             * 2 ~ n-1 找最小放到2
             * n ~ n-1 找最小放到n
             */
            int minValueIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                minValueIndex = a[minValueIndex] < a[j] ? minValueIndex : j;
            }
            /**
             * 交换
             */
            swap(a, i, minValueIndex);

        }
    }

    public static void bubbleSort(int[] arr) {
        int N = arr.length;
        /**
         * 0 ~ N-1 找到最大值放到N-1
         * 0 ~ N-2 找到最大值放到N-2
         * 0 ~ N-3 找到最大值放到N-3
         * 0 ~ N-4 找到最大值放到N-4
         * 0 ~ end
         */
        for (int end = N - 1; end >= 0; end--) {
            /**
             * 0 ~ end范围上
             * 0-1 1-2 2-3 3-4 end-1 - end
             */
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        /**
         * 0 ~ 0 有序从小到大
         * 0 ~ 1 有序从小到大
         * 0 ~ 2 有序从小到大
         * 0 ~ 3 有序从小到大
         * 0 ~ n-1 有序从小到大
         */
        int N = arr.length;
        for (int end = 0; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex, newNumIndex - 1);
                newNumIndex--;
            }

        }
    }


    public static void main(String[] args) {
        int[] a = {4, 5, 1, 7, 3, 8, 2, 6, 9};
        print(a);
        insertSort(a);
        print(a);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }


}
