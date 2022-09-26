package leetcode.easy01;

/**
 * @ClassName: q69
 * @Author: 5753
 * @Date: 2022/9/22 10:11
 * @Description: TODO
 */
public class q69 {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int L = 1;
        int R = x >> 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L + 1) >> 1);
            if (x / mid > mid && x / (mid + 1) < (mid + 1) || x / mid == mid) {
                return mid;
            }
            if (x / mid < mid) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
}
