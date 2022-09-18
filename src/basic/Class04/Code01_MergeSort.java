package basic.Class04;

/**
 * @ClassName: Code01_MergeSort
 * @Author: 5753
 * @Date: 2022/9/2 15:41
 * @Description: 归并排序 并计算小和
 */
public class Code01_MergeSort {

    public static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int M = L + ((R - L) >> 1);

        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int p1 = L;
        int p2 = M + 1;

        int[] help = new int[R - L + 1];
        int i = 0;
        int ans = 0;
        while (p1 <= M && p2 <= R) {
//            if (arr[p1] < arr[p2]) {
//                //当前P2这个数也是所以要加1
//                ans += arr[p1] * (R - p2 + 1);
//            }
            ans += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

        return ans;

    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;

        //只要步长小于当前数组长度
        while (step < N) {
            //当前组的第一个位置
            int L = 0;
            while (L < N) {
                //步长是左组与右组的分割
                int M = L + step - 1;
                //左组如果不够
                if (M >= N) {
                    break;
                }
                //右组可能存在不够的情况，当右组不够的时候右组的右边界位N-1
                int R = Math.min(M + step, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }

            //为了防止溢出
            if (step > N / 2) {
                break;
            }
            step <<= 1;
        }


    }

    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 7, 1, 9, 5, 2, 7, 3, 5, 6};
        int[] arr2 = {2, 3, 7, 1, 9, 5, 2, 7, 3, 5, 6};
        int i = mergeSort(arr1);
        int comparator = comparator(arr2);
        System.out.println("小和为："+i);
        System.out.println("小和为："+comparator);

//        mergeSort2(arr);
        for (int num : arr1) {
            System.out.println(num);
        }
    }

}
