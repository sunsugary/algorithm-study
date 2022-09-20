package leetcode;

/**
 * @ClassName: q04
 * @Author: 5753
 * @Date: 2022/9/20 8:52
 * @Description: TODO
 */
public class q04 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);
        int length = arr.length;
        int mid = length >> 1;
        double ans = 0;
        if (length % 2 == 0) {
            //偶数
            ans = (arr[mid] + arr[mid - 1]) / 2D;
        } else {
            ans = arr[mid];
        }
        return ans;
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] arr = new int[arr1.length + arr2.length];

        int r = 0;
        int l = 0;
        int index = 0;
        while (l < length1 && r < length2) {
            if (arr1[l] < arr2[r]) {
                arr[index++] = arr1[l++];
            } else {
                arr[index++] = arr2[r++];
            }
        }
        while (l < length1) {
            arr[index++] = arr1[l++];
        }
        while (r < length2) {
            arr[index++] = arr2[r++];
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6, 9};
        int[] arr2 = {2, 7, 8, 10, 88, 99};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
