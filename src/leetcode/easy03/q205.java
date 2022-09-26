package leetcode.easy03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q205
 * @Author: 5753
 * @Date: 2022/9/25 10:03
 * @Description: TODO
 */
public class q205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((map1.containsKey(x) && map1.get(x) != y) || (map2.containsKey(y) && map2.get(y) != x)) {
                return false;
            }
            map1.put(x, y);
            map2.put(y, x);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));

    }
}
