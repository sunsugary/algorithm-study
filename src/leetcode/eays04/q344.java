package leetcode.eays04;

/**
 * @ClassName: q344
 * @Author: 5753
 * @Date: 2022/9/27 17:33
 * @Description: TODO
 */
public class q344 {
    public void reverseString(char[] s) {
        int p1 = 0;
        int p2 = s.length - 1;
        while (p1 < p2){
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1--;
            p2--;
        }
    }
}
