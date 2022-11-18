package leetcode.greedy;

/**
 * @ClassName: q409
 * @Author: 5753
 * @Date: 2022/10/10 16:51
 * @Description: TODO
 */
public class q409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        int ans = 0;
        for (int times : count) {
            ans += times % 2;
        }
        return ans == 0 ? s.length() : s.length() - ans +1;
    }
}
