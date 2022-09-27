package leetcode.easy03;

/**
 * @ClassName: q278
 * @Author: 5753
 * @Date: 2022/9/27 11:39
 * @Description: TODO
 */
public class q278 {
    public  boolean isBadVersion(int version){ return  false;}

    public int firstBadVersion(int n) {
        int L = 0;
        int R = n;
        while (L < R){
            int mid = L + ((R - L) >> 1);
            if (isBadVersion(mid)) {
                R = mid;
            }else{
                L = mid+1;
            }
        }
        return L;
    }
}
