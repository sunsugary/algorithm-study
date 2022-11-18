package leetcode.easy04;

/**
 * @ClassName: q392
 * @Author: 5753
 * @Date: 2022/10/8 16:55
 * @Description: TODO
 */
public class q392 {
    public static boolean isSubsequence(String s, String t) {
        //判断S是不是T的子序列
        int p1 = 0;
        int p2 = 0;
        int l1 = s.length();
        int l2 = t.length();
        while (p1 < l1 && p2 < l2) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 >= l1;
    }

    public static void main(String[] args) {
        String s = "acb", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
