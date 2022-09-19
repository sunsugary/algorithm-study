package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q03
 * @Author: 5753
 * @Date: 2022/9/19 15:53
 * @Description: 找出一个字符串中不含有重复字符的最长子串长度
 */
public class q03 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        char[] arr = s.toCharArray();
        for (int start = 0, end = 0; end < n; end++) {
            if (map.containsKey(arr[end])) {
                start = Math.max(start, map.get(arr[end]));
            }
            ans = Math.max(ans, end - start + 1);
            map.put(arr[end], end + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
