package leetcode.easy03;

/**
 * @ClassName: q202
 * @Author: 5753
 * @Date: 2022/9/24 22:28
 * @Description: TODO
 */
public class q202 {

    public static   boolean isHappy(int n) {
        int slow = n;
        int fast = getAns(n);
        while (fast != 1 && slow != fast){
            slow = getAns(slow);
            fast = getAns(getAns(fast));
        }
        return fast == 1;
    }
    public static int getAns(int n){
        int ans = 0;
        while (n > 0){
            int i = n % 10;
            n = n /10;
            ans += i * i;
        }
        return ans;
    }

    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }


}
