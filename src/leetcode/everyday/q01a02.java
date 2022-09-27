package leetcode.everyday;

/**
 * @ClassName: q01a02
 * @Author: 5753
 * @Date: 2022/9/27 13:50
 * @Description: 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class q01a02 {
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] arr = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr[s1.charAt(i)]--;
            if (arr[s1.charAt(i)] < 0 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abd";
        System.out.println(CheckPermutation(s1, s2));

    }
}
