package begin.Demo02;

/**
 * N的阶乘累加
 *
 */
public class Code02 {

    public static long f1(int N){
        int ans = 0;
        for (int i = 1 ; i <= N ; i++){
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int M) {
        long ans = 1;
        for (int i = 1; i <= M ; i++){
            ans = ans * i;
        }
        return ans;
    }
    public static long f2(int N){
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans = ans + cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(f1(3));
        System.out.println(f2(3));
    }
}
