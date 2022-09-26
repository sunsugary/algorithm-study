package leetcode.easy02;

/**
 * @ClassName: q121
 * @Author: 5753
 * @Date: 2022/9/23 16:33
 * @Description: TODO
 */
public class q121 {
    public static int maxProfit(int[] prices) {
        int in = prices[0];
        int out = 0;

        for (int price : prices) {
            if (price < in) {
                in = price;
            }
            if (price > in) {
                out = Math.max((price - in), out);
            }
        }
        return out;
    }

    //暴力方法 分别计算出每一个买入节点 后卖出节点的收益 找最大值
    public static int maxProfit2(int[] prices) {
        int out = 0;
        int n;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                n = prices[j] - prices[i];
                out = Math.max(n, out);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1};
        String s = "12312";
        System.out.println(maxProfit2(arr));
    }

}
