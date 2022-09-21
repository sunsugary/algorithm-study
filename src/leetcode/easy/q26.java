package leetcode.easy;

/**
 * @ClassName: q26
 * @Author: 5753
 * @Date: 2022/9/21 16:30
 * @Description: TODO
 */
public class q26 {

    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] == nums[q]) {
                q++;
            } else {
                swap(nums, ++p, q++);
            }
        }
        return q - p;
    }

    public void swap(int[] arr, int k, int m) {
        int tmp = arr[k];
        arr[k] = arr[m];
        arr[m] = tmp;
    }

    public static void main(String[] args) {
        //0 0 0 1 1 1 2 2
        //0 1 2 0 1 1 0 2
        //0 1 2 0 0 1 1 2
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    }
}
