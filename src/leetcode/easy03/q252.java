package leetcode.easy03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: q252
 * @Author: 5753
 * @Date: 2022/9/26 14:05
 * @Description: TODO
 */
public class q252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = intervals[i - 1];
            int[] cur = intervals[i];
            if (cur[0] < last[1]) {
                return false;
            }
        }
        return true;
    }
}
