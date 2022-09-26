package leetcode.easy02;

/**
 * @ClassName: q171
 * @Author: 5753
 * @Date: 2022/9/24 18:37
 * @Description: TODO
 */
public class q171 {
    // ZABA
    // (int)(A - 'A')* 26^0 +
    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        int n = columnTitle.length() - 1;
        for (int i = 0; i < columnTitle.length(); i++) {
            char cur = columnTitle.charAt(i);
            ans += (int) (cur - 'A' + 1) * Math.pow(26, n--);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "BB";
        System.out.println(titleToNumber(s));
    }
}
