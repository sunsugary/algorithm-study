package leetcode.easy;

/**
 * @ClassName: q35
 * @Author: 5753
 * @Date: 2022/9/21 17:33
 * @Description: TODO
 */
public class q35 {
    public static int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target){
                R = mid - 1;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(arr, target));
    }
}
