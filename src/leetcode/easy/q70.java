package leetcode.easy;

/**
 * @ClassName: q70
 * @Author: 5753
 * @Date: 2022/9/22 14:44
 * @Description: TODO
 */
public class q70 {
    public static int climbStairs2(int n) {
        return process(n);
    }

    public static int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }

    private static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return process(n - 1) + process(n - 2);
    }


    public static void main(String[] args) {

        System.out.println(climbStairs(45));
    }
}
