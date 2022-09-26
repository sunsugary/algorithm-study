package leetcode.easy01;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q13
 * @Author: 5753
 * @Date: 2022/9/21 10:59
 * @Description: TODO
 */
public class q13 {
    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i = i + 2;
            }else{
                ans += map.get(s.substring(i,i+1));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
