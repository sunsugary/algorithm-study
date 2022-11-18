package leetcode.easy04;

/**
 * @ClassName: q374
 * @Author: 5753
 * @Date: 2022/10/8 15:26
 * @Description: TODO
 */
public class q374 {
    public class GuessGame{
        public int guess(int n){
            return n;
        }
    }
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int L = 0,R = n;
            while(L < R){
                int mid = L + ((R -L) >> 1);
                int pick = guess(mid);
                if(pick < 0){
                    R = mid-1;
                }else if(pick >0){
                    L = mid +1;
                }else{
                    return mid;
                }
            }
            return L;

        }
    }
}
