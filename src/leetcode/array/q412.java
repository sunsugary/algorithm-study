package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q412
 * @Author: 5753
 * @Date: 2022/10/10 17:06
 * @Description: TODO
 */
public class q412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if ( i % 3 == 0){
                sb.append("Fizz");
            }
            if (i % 5 == 0){
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0){
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "33810bb1-0834-4cfa-9XXXX-7594xxxx8401";
        System.out.println(s.length());
    }
}
