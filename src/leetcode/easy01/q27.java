package leetcode.easy01;

/**
 * @ClassName: q27
 * @Author: 5753
 * @Date: 2022/9/21 17:00
 * @Description: TODO
 */
public class q27 {
    public static int removeElement(int[] nums, int val) {
        int q = nums.length;
        int p = 0;
        while (p < q) {
            if (nums[p] == val) {
                nums[p] = nums[--q];
            } else {
                p++;
            }
        }
        return q;
    }

    public static void swap(int[] arr, int k, int m) {
        int tmp = arr[k];
        arr[k] = arr[m];
        arr[m] = tmp;
    }

    public static void main(String[] args) {
        // 0 1 2  2  3  0  4  2
        // 0 1 2` 2  3  0  4  2
        // 0 1 4 0 3 2 2` 2
        //
        int[] arr = { 5};
        System.out.println(removeElement(arr, 5));

        for (int i : arr) {
            System.out.println(i);
        }

    }
}
