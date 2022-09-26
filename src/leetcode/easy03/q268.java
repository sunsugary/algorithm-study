package leetcode.easy03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: q268
 * @Author: 5753
 * @Date: 2022/9/26 16:48
 * @Description: TODO
 */
public class q268 {
    //排序方法
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans = i;
                break;
            }
        }
        return ans == -1 ? nums.length : ans;
    }

    //哈希集合方法
    public static int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = -1;
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    //位运算做法
    public static int missingNumber3(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            eor ^= i;
        }
        return eor;
    }

    //数学做法 n个连续的数字求和 为 首项1 + 尾项n 乘以n/2
    public static int missingNumber4(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int sum2 = (1 + n) * n / 2;
        return sum2 - sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 6, 3, 4, 5};
        missingNumber(arr);
    }
}
