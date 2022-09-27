package leetcode.easy03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q290
 * @Author: 5753
 * @Date: 2022/9/27 14:25
 * @Description: TODO
 */
public class q290 {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String cur = arr[i];
            if (map1.containsKey(c) && !map1.get(c).equals(cur)){
                return false;
            }

            if (map2.containsKey(cur) && !map2.get(cur).equals(c)){
                return false;
            }

            if (!map1.containsKey(c) && !map2.containsKey(cur)){
                map1.put(pattern.charAt(i), arr[i]);
                map2.put(arr[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaaa";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }
}
