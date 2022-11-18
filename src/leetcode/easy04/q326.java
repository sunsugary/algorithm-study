package leetcode.easy04;

/**
 * @ClassName: q326
 * @Author: 5753
 * @Date: 2022/9/27 16:04
 * @Description: TODO
 */
public class q326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n > 1){
            if (n % 3 == 0) {
                n = n /3;
            }else{
                return false;
            }
        }
        return true;
    }
}
