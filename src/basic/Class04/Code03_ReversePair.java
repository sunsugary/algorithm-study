package basic.Class04;

/**
 * 逆序队问题：任何一个数，右边只要有一个比我小的数就算一对，有n个就算n对
 */
public class Code03_ReversePair {

    public static int reversePairNum(int[] arr) {
        if (arr == null || arr.length < 2) {
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

    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int p1 = M;
        int p2 = R;
        int[] help = new int[R - L + 1];
        int i = help.length - 1;
        int ans = 0;
        while (p1 >= L && p2 > M) {
//            if (arr[p1] > arr[p2]) {
//                ans += (p2 - M);
//            }
            ans += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }

        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 > M ) {
            help[i--] = arr[p2--];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 7, 1, 9, 5, 2, 7, 3, 5, 6};
        int[] arr2 = {2, 3, 7, 1, 9, 5, 2, 7, 3, 5, 6};
        int i = reversePairNum(arr1);
        int comparator = comparator(arr2);
        System.out.println("逆序队有几个：" + i);
        System.out.println("逆序队有几个：" + comparator);
        for (int num : arr1) {
            System.out.println(num);
        }
    }

}
