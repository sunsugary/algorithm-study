package basic.Class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: Code01_CoverMax
 * @Author: 5753
 * @Date: 2022/9/7 9:19
 * @Description: TODO
 */
public class Code01_CoverMax {
    /**
     * 给定很多线段，每个线段都有两个数[start,end]，表示线段开始位置和结束位置，左右都是闭区间。
     * 且规定：
     * 1）.线段的开始和结束位置一定都是整数值。
     * 2）.线段重合区域的长度必须>=1。返回线段最多重合区域中，包含了几条线段
     * 分析：
     * 1.找重合最多的区域线段条数，数轴有正无穷到负无穷个数，数轴上取无数个点，哪一个点被线段穿过最多，则为我们要求的值
     * 2.每一个重合区域的开始点必然是一个线段的开始点，假设每一个线段的开始点都是重合区域的开始点
     * 3.对每一条线段以开始位置进行排序，求以该线段开始点为重合区域的重合线段条数
     * 4.排序后以此将线段的结束点加入到一个堆中，由于我们是将线段从开始位置从小到大排列的，如果下一条线段的头节点小于上一条的尾节点，这两条线段必有重合区域
     * 5.每一个线段尾节点加入堆中的时候弹出比该线段头节点小的值，此时堆中剩余多少个数就有多少个重合
     **/
    public static class Line {
        public int start;
        public int end;

        public Line(int s, int e) {
            start = s;
            end = e;
        }
    }


    public static int coverMax(int[][] lines) {
        Line[] lineArr = new Line[lines.length];
        for (int i = 0; i < lines.length; i++) {
            lineArr[i] = new Line(lines[i][0], lines[i][1]);
        }

        Arrays.sort(lineArr, (Comparator.comparingInt(o -> o.start)));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxAns = 0;
        for (Line line : lineArr) {
            int start = line.start;
            int end = line.end;
            while (!heap.isEmpty() && heap.peek() <= start) {
                heap.poll();
            }
            heap.add(end);
            maxAns = Math.max(heap.size(), maxAns);
        }
        return maxAns;
    }


    /**
     * @return void
     * @Author 5753
     * @Description 暴力方法， 由题意可知线段长度必须>=1 所以x.5 所以每条线段必穿过x.5 统计穿过x.5最大值
     * @Date 10:12 2022/9/7
     * @Param [lines]
     **/
    public static int coverMax2(int[][] lines) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //取出所有线段中最大最小值

        for (int i = 0; i < lines.length; i++) {
            min = Math.min(lines[i][0], min);
            max = Math.max(lines[i][1], max);
        }
        int ansMax = 0;
        for (double p = min + 0.5; p < max; p++) {
            int ans = 0;
            for (int[] line : lines) {
                int start = line[0];
                int end = line[1];
                if (start < p && end > p) {
                    ans++;
                }
            }
            ansMax = Math.max(ans, ansMax);
        }

        return ansMax;


    }


    /**
     * @return int[][]
     * @Author 5753
     * @Description //随机线段
     * @Date 10:28 2022/9/7
     * @Param [N, L, R] N：线段的最多条数，L线段开始的最小值，线段结束的最大值
     **/
    public static int[][] generateLines(int N, int L, int R) {
        int size = (int) (Math.random() * (N + 1));
        int[][] lines = new int[size][2];

        for (int i = 0; i < lines.length; i++) {
            int start = L + (int) (Math.random() * (R - L + 1));
            int end = L + (int) (Math.random() * (R - L + 1));
            if (start == end) {
                end = end + 1;
            }
            lines[i][0] = Math.min(start, end);;
            lines[i][1] = Math.max(start, end);
        }
        return lines;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int N = 100;
        int L = 0;
        int R = 200;
        int testTimes = 200000;
        for (int i = 0; i < testTimes; i++) {
            int[][] lines = generateLines(N, L, R);
            int ans1 = coverMax(lines);
            int ans2 = coverMax2(lines);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test end");

    }


}
