package leetcode.easy04;

/**
 * @ClassName: q367
 * @Author: 5753
 * @Date: 2022/10/8 15:04
 * @Description: TODO
 */
public class q367 {
    public static boolean isPerfectSquare(int num) {
        int L = 0, R = num;
        while (L <= R) {
            int mid = L + ((R -L) >> 1);
            long square = (long) mid * mid;
            if (num > square) {
                L = mid + 1;
            } else if (num == square) {
                return true;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
