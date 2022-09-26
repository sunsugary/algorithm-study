package leetcode.easy02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q163
 * @Author: 5753
 * @Date: 2022/9/24 11:04
 * @Description: TODO
 */
public class q163 {
}

class Solution {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        int L = lower;
        int R = upper;
        int index = 0;
        while (L < R && index < nums.length) {
            if (nums[index] != L) {
                ans.add(start + "->" + end);
                start = L;
                L++;
            } else {
                end = L - 1;
                index++;
                L++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> missingRanges = findMissingRanges(nums, lower, upper);

    }


}
