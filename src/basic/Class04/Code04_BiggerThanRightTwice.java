package basic.Class04;

//测试链接：https://leetcode.cn/problems/reverse-pairs/
public class Code04_BiggerThanRightTwice {
    //给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        return process(nums, 0, nums.length - 1);

    }

    private int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);


    }

    private int merge(int[] arr, int L, int M, int R) {
        //计算重要翻转对
        int ans = 0;
        int winR = M + 1;
        int K = L;
        while (K <= M) {
            while (winR <= R && (long)arr[K] > (long)arr[winR] * 2) {
                winR++;
            }
            while (winR <= R && (long) arr[K] > (long)arr[winR] * 2) {
                winR++;
            }
            //当循环结束的时候意味着winR指针已经走到了边界，此时winR到M+1 范围的数都是乘以2都比i小的数
            ans += winR - (M + 1);
            K++;
        }
        //归并
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
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

}
