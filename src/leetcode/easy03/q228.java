package leetcode.easy03;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q228
 * @Author: 5753
 * @Date: 2022/9/25 15:35
 * @Description: TODO
 */
public class q228 {
    public static List<String> summaryRanges(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            p2 = i + 1;
            if (nums[p2] - nums[i] != 1) {
                if (nums[p1] == nums[p2 - 1]) {
                    ans.add(String.valueOf(nums[p1]));
                } else {
                    ans.add(nums[p1] + "->" + nums[p2 - 1]);
                }
                p1 = p2;
            }
        }
        return ans;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> ans = new ArrayList<String>();
        int p1 = 0;
        int p2 = 0;
        int n = nums.length;
        while (p2 < n) {
            p1 = p2;
            p2++;
            while (p2 < n && nums[p2] - nums[p2 - 1] == 1) {
                p2++;
            }
            if (p1 < p2 - 1) {
                ans.add(nums[p1] + "->" + nums[p2 - 1]);
            } else {
                ans.add(String.valueOf(nums[p1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,2,4,5,7,8,9,10,19,20,22,24,25,27};
        int[] arr = {0, 1, 2, 4, 5, 7};
        List<String> strings = summaryRanges2(arr);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
