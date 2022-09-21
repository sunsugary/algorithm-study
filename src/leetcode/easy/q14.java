package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q14
 * @Author: 5753
 * @Date: 2022/9/21 11:54
 * @Description: TODO
 */
public class q14 {
    public static String longestCommonPrefix(String[] strs) {
        String longString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < longString.length(); j++) {
                if (longString.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            longString = strs[i].substring(0, j);
        }
        return longString;
    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}
