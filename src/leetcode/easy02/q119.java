package leetcode.easy02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q119
 * @Author: 5753
 * @Date: 2022/9/23 15:51
 * @Description: //\mathcal{C}_n^m= \mathcal{C}_n^{m-1} \times \dfrac{n-m+1}{m}
 */
public class q119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.add(i,(int) ((long) ans.get(i - 1) * (rowIndex - i + 1) / i));
//            ans.add((int) ((long) ans.get(i-1) * (rowIndex - i + 1) / i);
//            ans.add((int) ((long) ans.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Integer> row = getRow(30);
        for (Integer num : row) {
            System.out.print(num + " ");
        }
    }
}
