package leetcode.easy05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: q448
 * @Author: 5753
 * @Date: 2022/10/26 10:23
 * @Description: TODO
 */
public class q448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 1; i < nums.length; i++,j++) {
            if (nums[i] != j) {
                ans.add(j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        findDisappearedNumbers(arr);
    }
}
