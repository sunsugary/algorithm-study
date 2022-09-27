package leetcode.easy03;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q293
 * @Author: 5753
 * @Date: 2022/9/27 15:26
 * @Description: TODO
 */
public class q293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = s.charAt(i - 1);
            if (c == '+' && c1 == '+'){
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i-1,i+1,"-");
                list.add(sb.toString());
            }
        }
        return list;
    }
}
