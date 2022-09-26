package leetcode.easy03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q246
 * @Author: 5753
 * @Date: 2022/9/25 19:40
 * @Description: TODO
 */
public class q246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character,Character> map=new HashMap<Character,Character>();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        int L = 0;
        int R = num.length()-1;
        while (L <= R) {
            char c1 = num.charAt(L);
            char c2 = num.charAt(R);

            if (!map.containsKey(c1) || !map.containsKey(c2)) {
                return false;
            }

            if (map.get(c1) != c2 || map.get(c2) != c1) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }





}
