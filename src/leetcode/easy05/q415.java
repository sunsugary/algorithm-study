package leetcode.easy05;

/**
 * @ClassName: q415
 * @Author: 5753
 * @Date: 2022/10/14 9:24
 * @Description: TODO
 */
public class q415 {
    public static String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) return addStrings(num2, num1);
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 && p2 >= 0) {
            int a = (num1.charAt(p1) - '0');
            int b = (num2.charAt(p2) - '0');
            int c = a + b + carry;
            carry = c / 10;
            sb.append(c % 10);
            p1--;
            p2--;
        }

        while (p1 >= 0) {
            int a = (num1.charAt(p1) - '0');
            int c = a + carry;
            carry = c / 10;
            sb.append(c % 10);
            p1--;
        }
        if (carry > 0) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "456", num2 = "77";
        System.out.println(addStrings(num1, num2));
    }
}
