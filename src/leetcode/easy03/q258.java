package leetcode.easy03;

/**
 * @ClassName: q258
 * @Author: 5753
 * @Date: 2022/9/26 14:40
 * @Description: TODO
 */
public class q258 {
    public static int addDigits(int num) {
        if (num < 10) return num;
        String nums = String.valueOf(num);
        int ans = 0;
        while (nums.length() > 1) {
            ans = 0;
            for (int i = 0; i < nums.length(); i++) {
                ans += (int) (nums.charAt(i) - '0');
            }
            nums = String.valueOf(ans);
        }
        return ans;
    }

    public static int addDigits2(int num) {
        if (num < 10) return num;
        int ans = 0;
        int i = addDigits2(num / 10);
        ans += i;
        return ans;
    }

    private static int process(int ans, int num) {
        if (num == 0) return 0;
        ans += num % 10;
        process(ans, num / 10);
        return ans;
    }

    public static void main(String[] args) {
        int n = 38;
        System.out.println(addDigits(n));

    }
}
