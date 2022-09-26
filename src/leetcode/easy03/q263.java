package leetcode.easy03;

/**
 * @ClassName: q263
 * @Author: 5753
 * @Date: 2022/9/26 15:30
 * @Description: TODO
 */
public class q263 {
    public boolean isUgly(int n) {
        while (n % 2 ==0){
            n = n /2;
        }
        while (n % 3 == 0){
            n = n /3;
        }
        while (n % 5 == 0){
            n = n /5;
        }
        return n == 1;
    }
}
