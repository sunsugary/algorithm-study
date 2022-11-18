package leetcode.easy04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q350
 * @Author: 5753
 * @Date: 2022/10/8 14:45
 * @Description: TODO
 */
public class q350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length){
            return intersect(nums2,nums1);
        }
        //nums2为较短的数组
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[nums1.length];
        int index = 0;
        for (int num : nums1) {
            Integer count = map.getOrDefault(num, 0);
            if (count > 0){
                ans[index++] = num;
                count--;
                if (count >0){
                    map.replace(num,count);
                }else{
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(ans,0,index);

    }
}
