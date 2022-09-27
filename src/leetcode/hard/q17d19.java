package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: q17d19
 * @Author: 5753
 * @Date: 2022/9/27 9:28
 * @Description: 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 */
public class q17d19 {
    /**
     * 解题思路：数组包含1~N之间所有的整数，这些数都只出现了1次
     * 如果把1~N这N个数再添加到这个数组中，那么总共有2N-2个数，因为少了两个数
     * 此时这道题就能转换成，K个数出现了奇数次，M个数出现了两次的这个问题
     * eor异或上这个数组的所有数 最终eor = a^b a和b就是缺失的那两个数字
     * eor二进制位上最右边R位为1的位 一定是a和b R位异或过来的值，那么就说明a和b一定在R位上一个为1一个为0
     * 用eor再去异或上所有R位为1的数 就能得到a和b中的其中一个
     * <p>
     * 怎么取到最右边为1的位置R
     * 需要将除R位上所有的数变成0，只留R位是1
     * a & ( ~a + 1)  = a & -a
     * 例子：a -> 101011
     * ~a -> 010100
     * ~a+1 -> 010101
     * a & ( ~a + 1) -> 000001 得到最右边的1
     **/

    public static int[] missingTwo(int[] nums) {
        int N = nums.length + 2;
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        for (int i = 1; i <= N; i++) {
            eor ^= i;
        }
        //此时eor = a^b
        //eorR 就是最右边为1的那个数
        int eorR = eor & -eor;
        int a = 0;
        for (int num : nums) {
            if ((num & eorR) != 0) {
                a ^= num;
            }
        }
        for (int i = 1; i <= N; i++) {
            if ((i & eorR) != 0) {
                a ^= i;
            }
        }
        return new int[]{a, eor ^ a};
    }

    public static int[] missingTwo2(int[] nums) {
        int N = nums.length + 2;
        int sum = (N + 1) * N / 2;

        for (int num : nums) {
            sum -= num;
        }
        //此时sum = a+b
        int mid = sum / 2;
        // a  mid  b



        int sum3 = (mid + 1) * mid / 2;
        for (int num : nums) {
            if (num <= mid) sum3 -= num;
        }
        int b = sum - sum3;
        return new int[]{sum3,b};

    }

    public static int[] missingTwo3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int N = nums.length+2;
        int[] ans = new int[2];
        int index =0;
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                ans[index++] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 9, 10};
//        System.out.println(1 ^ 3);
        System.out.println(missingTwo3(arr));
    }

}
