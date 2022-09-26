package leetcode.easy03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q217
 * @Author: 5753
 * @Date: 2022/9/25 11:00
 * @Description: TODO
 */
public class q217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ; i < nums.length ; i ++){
            if(map.containsKey(nums[i])) {
                return true;
            }else{
                map.put(nums[i],1);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }


}
