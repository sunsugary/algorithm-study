package leetcode.easy03;

/**
 * @ClassName: q31
 * @Author: 5753
 * @Date: 2022/9/25 17:07
 * @Description: TODO
 */
public class q231 {
    public static boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPowerOfTwo2(int n) {
        //如果一个数是2的幂 那么这个数的32位2进制数中只有一个1 当我们把这个数减1的时候 得到有1的这一位后面全是1
        //所以 n & (n - 1) == 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isPowerOfTwo(n));
    }
}
