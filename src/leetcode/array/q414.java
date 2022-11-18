package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName: q414
 * @Author: 5753
 * @Date: 2022/10/11 10:39
 * @Description: TODO
 */
public class q414 {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int diff = 1;
        int ans = 0;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] != nums[i]) {
                diff++;
            }
            if (diff == 3) {
                ans = i;
                break;
            }
        }
        return diff >= 3 ? nums[ans - 1] : nums[nums.length - 1];
    }

    public static int thirdMax2(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() >= 3 ? set.first() : set.last();
    }

    public static int thirdMax3(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if ((b == null || num > b) && num < a) {
                c = b;
                b = num;
            } else if (b != null && num < b && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null ? a : c;

    }

    public static void main(String[] args) {
        System.out.println(thirdMax3(new int[]{1, 2, 3}));
    }
}
