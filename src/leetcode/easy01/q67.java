package leetcode.easy01;

public class q67 {
    public static String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = la - 1, j = lb - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ca = sum / 2;
            ans.append(sum % 2);
        }
        if (ca == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "1";
//        System.out.println(s1.charAt(-1));
        System.out.println(addBinary(s1, s2));
    }
}
