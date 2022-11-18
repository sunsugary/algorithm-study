package leetcode.easy04;

/**
 * @ClassName: q389
 * @Author: 5753
 * @Date: 2022/10/8 16:36
 * @Description: TODO
 */
public class q389 {
    public static char findTheDifference(String s, String t) {
        if (s.length() < t.length()) {
            return findTheDifference(t, s);
        }
        int[] arr = new int[26];
        int n1 = s.length();
        char ans = s.charAt(n1 - 1);
        for (int i = 0; i < n1; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int n2 = t.length();
        for (int i = 0; i < n2; i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ans = (char) ('a' + i);
                break;
            }
        }
        return ans;
    }
    //求和 将as
    public static char findTheDifference2(String s, String t) {
        int sum1 = 0;
        for (int i = 0; i < s.length(); i++) {
            sum1 += s.charAt(i) - 'a';
        }
        int sum2 =0;
        for (int i = 0; i < t.length(); i++) {
            sum2 += t.charAt(i) - 'a';
        }
        int diff = Math.abs(sum1 - sum2);
        return (char)(diff + 'a');
    }


    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }
}
