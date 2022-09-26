package leetcode.easy01;

public class q58 {

    public static int lengthOfLastWord(String s) {
        int n = s.length();
        while (n > 0 && s.charAt(n - 1) == ' ') {
            n--;
        }
        StringBuilder ans = new StringBuilder();
        while (n > 0 && s.charAt(n - 1) != ' ') {
            ans.append(s.charAt(n - 1));
            n--;
        }
        return ans.length();
    }

    public static void main(String[] args) {

        String s = " fadsf safd  moon     ";
        System.out.println(lengthOfLastWord(s));
    }
}
