package basic.Class05;

// https://leetcode.cn/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {

    /**
     * 题意：给一个数组arr[]，然后给定一个值的范围[lower,upper]，问这个数组中有几个子数组的和在这个范围
     * 首先给这个数组转换成前缀和数组sum[0....R], sum[1]代表arr[0]+arr[1]的和 sum[3]代表arr[0]+arr[1]+arr[2]+arr[3]的和
     * 有了sum[] 就可以快速计算出arr[k]....arr[M]这个范围的数和
     * sum这个数组在归并的时候，
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        return process(sum, lower, upper, 0, sum.length - 1);

    }

    private int process(long[] sum, int lower, int upper, int L, int R) {
        if (L == R) {
            if (sum[L] >= lower && sum[L] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int M = L + ((R - L) >> 1);
        return    process(sum, lower, upper, L, M)
                + process(sum, lower, upper, M + 1, R)
                + merge(sum, lower, upper, L, M, R);


    }

    private int merge(long[] sum, int lower, int upper, int L, int M, int R) {
        int leftL = L;
        int leftR = L;
        int ans = 0;
        //遍历右组数
        for (int i = M + 1; i <= R; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (leftR <= M && sum[leftR] <= max) {
                leftR++;
            }
            while (leftL <= M && sum[leftL] >= min) {
                leftL++;
            }
            ans += (leftR - leftL);
        }
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }

        while (p1 <= M) {
            help[i++] = sum[p1++];
        }
        while (p2 <= R) {
            help[i++] = sum[p2++];
        }

        for (i = 0; i < help.length; i++) {
            sum[L + i] = help[i];
        }
        return ans;
    }

}
