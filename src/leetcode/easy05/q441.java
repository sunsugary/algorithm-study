package leetcode.easy05;

/**
 * @ClassName: q441
 * @Author: 5753
 * @Date: 2022/10/19 11:25
 * @Description: TODO
 */
public class q441 {
    //如果恰好够排列，就是一个等差数列
    //等差数列的求和公式为：k(k+1)/2
    //如果第K行正好是完整的，那么总共需要的金币数量就是k(k+1)/2
    public static int arrangeCoins(int n) {
        int L = 1;
        int R = n;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (mid * (mid + 1) / 2 < n) L = mid + 1;
            else if (mid * (mid + 1) / 2  == n) return mid;
            else R = mid - 1;
        }
        return L;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(2));
    }
}
