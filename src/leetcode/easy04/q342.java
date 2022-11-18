package leetcode.easy04;

/**
 * @ClassName: q342
 * @Author: 5753
 * @Date: 2022/9/27 17:11
 * @Description: TODO
 */
public class q342 {
    public boolean isPowerOfFour(int n) {
        //如果一个数是4的幂 那就一定是2的幂 所以这个数的二进制只有一位是1
        //通过观察我们可以得到这个1必定在二进制位的偶数位上
        //定义一个二进制数，它的偶数位上全是1，那么这个数与n作按位与运算的时候 就会等于0
        //01010101010101010101010101010101 = 0xaaaaaaaa

        if (n <= 0) return false;
        return (n & (n - 1)) == 0 && ((n & (0xaaaaaaaa)) == 0);
    }
}
