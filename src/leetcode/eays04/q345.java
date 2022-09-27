package leetcode.eays04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: 反转字符串中的元音字母
 * @Author: 5753
 * @Date: 2022/9/27 17:44
 * @Description: TODO
 */
public class q345 {
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Character[] arr = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>(Arrays.asList(arr));
        int p1 = 0;
        int p2 = s.length()-1;
        while (p1 < p2){
            if (set.contains(chars[p1]) && set.contains(chars[p2])){
                char tmp = chars[p1];
                chars[p1] = chars[p2];
                chars[p2] = tmp;
                p1++;
                p2--;
            }
            if (!set.contains(chars[p1])){
                p1++;
            }
            if (!set.contains(chars[p2])){
                p2--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
