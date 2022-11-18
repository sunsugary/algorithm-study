package leetcode.easy04;

import java.util.*;

/**
 * @ClassName: q349
 * @Author: 5753
 * @Date: 2022/10/8 9:25
 * @Description: TODO
 */
public class q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (num == nums2[j]){
                    set.add(num);
                    break;
                }
            }
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            ans[index++] = num;
        }
        return  ans;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int p1 = 0;
        int p2 = 0;
        int pre = -1;
        int[] ans = new int[l1+l2];
        int index = 0;
        while (p1 < l1 && p2 < l2){
            if (nums1[p1] < nums2[p2]){
                p1 ++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else {
                if (pre != nums1[p1]){
                    ans[index++] = nums1[p1];
                    pre = nums1[p1];
                }
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }
}
