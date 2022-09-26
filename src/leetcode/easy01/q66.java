package leetcode.easy01;

public class q66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }


    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        int[] arr = {9, 9};
        plusOne2(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
