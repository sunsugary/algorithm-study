package leetcode.easy03;

/**
 * @ClassName: q283
 * @Author: 5753
 * @Date: 2022/9/27 14:08
 * @Description: TODO
 */
public class q283 {
    public static void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length){
            if (nums[p2] == 0) {
                p2++;
            }else{
                swap(nums,p2,p1);
                p1++;
                p2++;
            }
        }
    }

    public static void swap(int[] arr ,int k , int m){
        int tmp = arr[k];
        arr[k] = arr[m];
        arr[m] = tmp;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,2,0,3,12};
        moveZeroes(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
