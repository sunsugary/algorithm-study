package begin.Demo02;

public class Code08 {
    /**
     * 有一个f1函数 会以p概率返回0 1-p概率返回1
     * <p>
     * 现在求g函数等概率返回0，1
     * <p>
     * 骰两次f1函数 总共会有
     * 00 概率为p * p
     * 01 概率为p * (1-p)
     * 10 概率为(1-p) * p
     * 11 概率为(1-p) * (1-p)
     * 四种情况
     * 可以看出骰到01 和 10得概率是相等得
     * 如果我把骰到 11 和 00 得概率平均分给01 和 10则可以等概率返回 01 和 10
     */
    public static int f1() {
        return Math.random() < 0.6 ? 0 : 1;
    }

    public static int f2() {
        int ans1 = 0;
        int ans2 = 0;
        do {
            ans1 = f1();
            ans2 = f1();
        } while (ans1 == ans2);
        return ans1 == 0 && ans2 == 1 ? 0 : 1;
    }

    public static void main(String[] args) {
        int timesNum = 10000;
        int count = 0;
        for (int i = 0; i < timesNum; i++) {
            int ans = f2();
            if (ans == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) timesNum);

    }
}

