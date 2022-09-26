package leetcode.easy02;

public class q136 {
    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor^= num;
        }
        return eor;
    }
}
