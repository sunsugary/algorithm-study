package leetcode.easy;

/**
 * @ClassName: q09
 * @Author: 5753
 * @Date: 2022/9/21 10:14
 * @Description: TODO
 */
public class q09 {
    public static boolean isPalindrome(int x) {
        String nums = String.valueOf(x);
        char[] chars = nums.toCharArray();
        int t = chars.length - 1;
        int h = 0;
        while(h < t){
            if ((int)chars[h] == (int)chars[t]){
                h++;
                t--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(int x) {
        int num = x;
        int cur = 0;
        if (x < 0){
            return false;
        }
        while (num != 0){
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        return x == cur;
    }
}
