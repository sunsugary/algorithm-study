package leetcode.easy03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 存在重复元素II
 * @Author: 5753
 * @Date: 2022/9/25 11:06
 * @Description: TODO
 */
public class q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) return true;
            map.put(cur, i);
            if (map.size() > k) {
                map.remove(nums[i - k]);
            }
        }
        return false;
    }

}
