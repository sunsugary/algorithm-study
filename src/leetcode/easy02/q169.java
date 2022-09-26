package leetcode.easy02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q169
 * @Author: 5753
 * @Date: 2022/9/24 18:22
 * @Description: TODO
 */
public class q169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int target = nums.length / 2;
        int ans = nums[0];
        for (int num : nums) {
            if(map.containsKey(num)){
                Integer times = map.get(num);
                if (times +1 > target){
                    ans = num;
                }else{
                    map.put(num,times+1);
                }
            }else{
                map.put(num,1);
            }
        }
        return ans;
    }
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElement3(int[] nums){
        int cout = 1;
        int ans = nums[0];
        for (int num : nums) {
            if (cout == 0){
                ans = num;
            }
            if (num == ans){
                cout++;
            }else{
                cout--;
            }
        }
        return ans;
    }
}
