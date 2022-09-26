package leetcode.easy02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q118
 * @Author: 5753
 * @Date: 2022/9/23 13:50
 * @Description: TODO
 */
public class q118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //外循环控制行
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i){
                    curRow.add(1);
                }else{
                    curRow.add(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(curRow);
        }
        return ans;
    }

    // 输入: numRows = 5
    // 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    //1
    //1 1
    //1 2 1
    //1 3 3 1
    //1 4 6 4 1
    //1 5 10 10 1
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(30);
        for (int i = 0; i < generate.size(); i++) {
            List<Integer> integers = generate.get(i);
            for (int i1 = 0; i1 < integers.size(); i1++) {
                System.out.print(integers.get(i1) + " ");
            }
            System.out.println();
        }
    }
}
