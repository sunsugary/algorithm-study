package leetcode.easy05;

/**
 * @ClassName: q434
 * @Author: 5753
 * @Date: 2022/10/19 10:48
 * @Description: TODO
 */
public class q434 {
    public int countSegments(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if ((i == 0 || s.charAt(i - 1) == 32) && s.charAt(i) != 32) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        char space = ' ';
        System.out.println((int) space);
    }

}
