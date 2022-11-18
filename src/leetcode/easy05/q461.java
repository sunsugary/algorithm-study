package leetcode.easy05;

/**
 * @ClassName: q461
 * @Author: 5753
 * @Date: 2022/11/17 14:33
 * @Description: TODO
 */
public class q461 {
    public static int hammingDistance(int x, int y) {
        StringBuilder sx =new StringBuilder();
        StringBuilder sy = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sx.append(((1 << i) & x) == 0 ? "0":"1");
            sy.append(((1 << i) & y) == 0 ? "0":"1");
        }
        int p1 = 0;
        int p2 = 0;
        int ans = 0;
        while (p1 < sx.length()) {
            if (sx.charAt(p1) != sy.charAt(p2)) {
                ans++;
            }
            p1++;
            p2++;
        }
        return ans;
    }

    public static int hammingDistance2(int x, int y) {
        //两个数进行异或运算 比较二进制位 相同为0不同为1
        return Integer.bitCount(x ^ y);
    }

    public static int hammingDistance3(int x, int y) {
        //两个数进行异或运算 比较二进制位 相同为0不同为1
        int s = x ^ y;
        int ans = 0;
        while (s != 0){
            s &= (s-1);
            ans++;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(93, 73));
        System.out.println(hammingDistance2(93, 73));
        System.out.println(hammingDistance3(93, 73));
    }
}
