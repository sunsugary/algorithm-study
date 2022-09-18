package begin.Demo02;

public class Code06 {

    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    /**
     * [0,1)范围每个数出现的概率是一样的
     * [0,10)范围每个数出现的概率是一样的
     * 小于3的概率应为0.3
     */
    public static double XRandom() {
        return (int) (Math.random() * 10);
    }

    /**
     * f(x)函数 该函数随机返回1~5 任意一个数 并且概率是相等的
     * <p>
     * 现在我想得到一个函数g(x) 该函数随机返回1~7 任意一个数 并且概率是相等的
     * <p>
     * 思路：f(x) 1,2,3,4,5 让该函数返回两个数 并且是等概率的 简称 0 1发生器
     * <p>
     * 例如返回1,2 则返回0. 返回4,5 则返回1. 返回3重新再来一次
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 0，1发生器
     *
     * @return
     */
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 现在有了0，1发生器了
     * 目标是1~7
     * 能不能得到0~6
     */
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2());
    }

    /**
     * 得到了0~6的等概率函数
     */
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    /**
     * 最终得到g函数
     * 1~7上等概率函数
     */
    public static int g() {
        return f4() + 1;
    }

    public static void main(String[] args) {
        int testTimes = 100000;
        int count = 0;
//        int N = 9;
//        int[] counts = new int[N];
//        for (int i = 0; i < testTimes; i++) {
//            int ans = (int) (Math.random() * N);
//            counts[ans]++;
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(counts[i]);
//        }
//        double x = 3;
//        for (int i = 0; i < testTimes; i++) {
//            if (XRandom() < x) {
//                count++;
//            }
//        }
//        System.out.println((double) count / (double) testTimes);
        int count2 = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        int N = 8;
        int[] arr = new int[N];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            arr[num]++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "这个数出现了 " + arr[i] + " 次");
        }
//        count = 0;
//        for (int i = 0; i < testTimes; i++) {
//            if (f3() == 7) {
//                count++;
//            }
//        }
//        System.out.println((double) count / (double) testTimes);
//        System.out.println((double) count / (double) testTimes);
//        System.out.println((double) count2 / (double) testTimes);
    }
}
