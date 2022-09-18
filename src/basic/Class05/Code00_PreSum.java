package basic.Class05;

public class Code00_PreSum {
    private int[] sums;

    public static class NumArray {
        private int[] sums;

        public NumArray(int[] arr) {
            sums = new int[arr.length];
            sums[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                sums[i] = sums[i - 1] + arr[i];
            }
        }

        public int preSum(int k, int j) {
            return k == 0 ? sums[j] : sums[j] - sums[k - 1];
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 7, 6, 0, 6, 2, 0, 7};
        NumArray numArray = new NumArray(arr);

        System.out.println(numArray.preSum(0, 2));
    }

}
