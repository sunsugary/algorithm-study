package leetcode.easy02;

/**
 * @ClassName: q125
 * @Author: 5753
 * @Date: 2022/9/23 17:26
 * @Description: TODO
 */
public class q125 {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        s = sb.toString();
        int L = 0;
        int R = s.length()-1;
        while (L < R){
            if (s.charAt(L++) != s.charAt(R--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a planc, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
