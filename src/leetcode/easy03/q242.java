package leetcode.easy03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q242
 * @Author: 5753
 * @Date: 2022/9/25 18:59
 * @Description: TODO
 */
public class q242 {
    public static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            arr[cur]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int cur = t.charAt(i) - 'a';
            if ((arr[cur]--) < 0) {
                return false;
            }
        }
        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
    }
}
