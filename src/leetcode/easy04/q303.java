package leetcode.easy04;

/**
 * @ClassName: q303
 * @Author: 5753
 * @Date: 2022/9/27 15:48
 * @Description: TODO
 */
public class q303 {

}

class NumArray {
    int[] arr;
    int[] sum;

    public NumArray(int[] nums) {
        arr = nums;
        sum = new int[nums.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left - 1];
    }
}