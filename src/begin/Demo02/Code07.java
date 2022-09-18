package begin.Demo02;

public class Code07 {
    /**
     * f1()函数3-19上得到任意一个数是等概率的
     * 求g() 在20-56上得到任意一个数是等概率的
     * <p>
     * 思路：首先需要一个0，1发生器
     * 再看多少个二进制位能满足56
     */
    public static int f1() {
        return (int) (Math.random() * 17) + 3;
    }

    /**
     * 将f1函数改为01发生器
     */
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 11);
        return ans < 11 ? 0 : 1;
    }

    /**
     * 现在需要一个0~37等概率发生器
     * 总共需要6个二进制位 才能表示56
     */
    public static int f3() {
        int i5 = f2() << 5;
        int i4 = f2() << 4;
        int i3 = f2() << 3;
        int i2 = f2() << 2;
        int i1 = f2() << 1;
        int i0 = f2() << 0;
        return i5 + i4 + i3 + i2 + i1 + i0;
    }

    /**
     * 0~36的等概率发生器
     */
    public static int f4(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans > 36);
        return ans;
    }

    /**
     *
     */
    public static int g(){
        return f4()+20;
    }





    public static void main(String[] args) {
        int N = 64;
        int[] arr = new int[N];
        int timesNum = 100000;

        for (int i = 0; i < timesNum; i++) {
            int index = g();
            arr[index]++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "这个数出现了 " + arr[i] + " 次");
        }
        System.out.println("=============");

        int count = 0;
        for (int i = 0; i < timesNum; i++) {
        }
        System.out.println((double) count / (double) timesNum);

    }


}
