package begin.Demo4;

public class Code03_BitAddMinusMultiDiv {
    /**
     * ^异或运算是无进位相加  进位信息是&与运算并左移一位
     */

    public static void main(String[] args) {
        print(46);
        System.out.println();
        print((~46) + 1);
        System.out.println();
        print(-46);
//        System.out.println();
//        print(46 & 20 << 1);
//        System.out.println();
//        print(66);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    //使用位运算实现a+b
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            //无进位相加
            sum = a ^ b;
            //进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //使用位运算实现a-b
    public static int minus(int a, int b) {
        /**
         * 一个数的负数为 取反+1
         *  add(a,~b+1);
         *  add(a,add(~b,1))
         */
        return add(a, add(~b, 1));

    }

    //使用位运算实现
    public static int multi(int a, int b) {
        /**
         *          1101
         *          1001
         *
         *       0011010
         *       0000000
         *       0110100
         *       1101000
         *
         */
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }
}
