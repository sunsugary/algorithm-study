package leetcode.easy01;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q01
 * @Author: 5753
 * @Date: 2022/9/19 12:40
 * @Description: TODO
 */
public class q01 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = target - nums[i];
            if (map.containsKey(num)) {
                ans[0] = i;
                ans[1] = map.get(num);
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}