package leetcode.easy04;

/**
 * @ClassName: q338
 * @Author: 5753
 * @Date: 2022/9/27 16:22
 * @Description: TODO
 */
public class q338 {
    // 12 -> 1 1 0 0
    // 11 -> 1 0 1 1
    // 12 & 11 -> 1 0 0 0
    // n这个数的最后一位1变成了0 重复这个操作看进行了多少次

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getTimes(i);
        }
        return arr;
    }

    //一个数只要是2的幂次方那么这个数的二进制中只有一个1，所以它的下一个数二进制中含1的数量比它多1
    public int[] countBits2(int n) {
        int[] arr = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i < arr.length; i++) {
            if ((i & (i-1)) == 0){
                highBit = i;
            }

        }


        return arr;
    }
    private int getTimes(int x) {
        int ans = 0;
        while (x != 0) {
            x = x & (x-1);
            ans++;
        }
        return ans;
    }
}
