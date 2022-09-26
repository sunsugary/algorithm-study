package leetcode.easy02;

import java.util.Stack;

/**
 * @ClassName: q190
 * @Author: 5753
 * @Date: 2022/9/24 20:49
 * @Description: TODO
 */
public class q190 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        //00111001011110000010100101000000
        //
        //00000010100101000001111010011100
        int n = 964176192;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>>= 1;
        }


    }
}
