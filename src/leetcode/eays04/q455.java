package leetcode.eays04;

import java.util.Arrays;

public class q455 {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gl = g.length, sl = s.length;

        for (int i = 0, j = 0; i < gl && j < sl; i++, j++) {
            while (j < sl && g[i] > s[j]){
                //由于已经排序过了 从小到大 如果第一个块饼干不满足第一个孩子的胃口 那么这块饼干可以直接排除掉了 因为后面的孩子
                //的胃口是越来越大的
                //当饼干没有遍历到最后一个且当前便利的饼干不满足孩子的胃口
                j++;
            }
            if (j < sl){
                //此时说明有一个饼干能满足孩子的胃口
                count++;
            }
        }
        return count;
    }
}
