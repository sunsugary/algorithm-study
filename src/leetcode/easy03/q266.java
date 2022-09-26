package leetcode.easy03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q266
 * @Author: 5753
 * @Date: 2022/9/26 15:44
 * @Description: TODO
 */
public class q266 {
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (Integer value : map.values()) {
            count += value % 2;
        }
        return count <=1;
    }

    public static boolean canPermutePalindrome2(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length && count < 2; i++) {
            count += arr[i] % 2;
        }
        return count < 2;
    }

    public static boolean canPermutePalindrome3(String s) {
        int[] arr = new int[128];
        int count = 0; //计算出现奇数次的数的次数
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
            if (arr[s.charAt(i)] % 2 == 0){
                count --;
            }else{
                count ++;
            }
        }
        return count < 2;
    }


    public static void main(String[] args) {
        String s = "code";
        System.out.println(canPermutePalindrome(s));
    }
}
