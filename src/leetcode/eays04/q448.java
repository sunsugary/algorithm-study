package leetcode.eays04;
import java.util.ArrayList;
import java.util.List;
public class q448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        //假设nums中有一个数是3，那么它应该在数组中准确的位置是在索引2处
        for (int num : nums) {
            arr[num - 1] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) ans.add(i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,3};
        findDisappearedNumbers(arr);
    }
}
