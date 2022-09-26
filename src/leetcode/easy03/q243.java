package leetcode.easy03;

/**
 * @ClassName: 最短单词距离
 * @Author: 5753
 * @Date: 2022/9/25 19:23
 * @Description: TODO
 */
public class q243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                p1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                p2 = i;
            }
            if (p1 >= 0 && p2 >= 0) {
                ans = Math.min(ans, Math.abs(p1 - p2));
            }
        }
        return ans;
    }
}
