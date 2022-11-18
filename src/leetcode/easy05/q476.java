package leetcode.easy05;

/**
 * @ClassName: q476
 * @Author: 5753
 * @Date: 2022/11/17 15:57
 * @Description: TODO
 */
public class q476 {
    public static int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(num));
        String s = sb.reverse().toString();
        return Integer.valueOf(s,2);
    }

    public static void main(String[] args) {
        findComplement(5);

    }
}
