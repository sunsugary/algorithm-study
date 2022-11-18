package leetcode.easy04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName: q387
 * @Author: 5753
 * @Date: 2022/10/8 16:03
 * @Description: TODO
 */
public class q387 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        int n = s.length();

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;


    }

    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar3(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur,i);
                queue.offer(new Pair(cur,i));
            }else{
                map.replace(cur,-1);
                while (!queue.isEmpty() &&  map.get(queue.peek().c) == -1){
                    queue.poll();
                }
            }
        }
        return queue.isEmpty()? -1: queue.poll().index;

    }
    public static class Pair{
        char c;
        int index;

        public Pair(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar3("leetcode"));
    }
}
