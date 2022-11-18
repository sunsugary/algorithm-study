package leetcode.easy05;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q401
 * @Author: 5753
 * @Date: 2022/10/9 10:07
 * @Description: TODO
 */
public class q401 {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(":");
                    if (j < 10){
                        sb.append("0");
                        sb.append(j);
                    }else {
                        sb.append(j);
                    }
                    ans.add(sb.toString());
                }

            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println("sdflkjalfdjlasdjfalskdfjasdlf");
        System.out.println(readBinaryWatch(1));
    }
}
