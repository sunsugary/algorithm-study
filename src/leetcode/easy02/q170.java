package leetcode.easy02;

import java.util.*;

/**
 * @ClassName: q170
 * @Author: 5753
 * @Date: 2022/9/24 19:44
 * @Description: TODO
 */
public class q170 {
}

class TwoSum {
    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            map.replace(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Integer num : map.keySet()) {
            int t = value - num;
            if (t != num) {
                if (map.containsKey(t)) {
                    return true;
                }
            } else {
                if (map.get(num) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

class TwoSum2 {
    List<Integer> arr;

    public TwoSum2() {
        arr = new ArrayList<>();
    }

    public void add(int number) {
        arr.add(number);
    }

    public boolean find(int value) {
        arr.sort(Comparator.comparingInt(o -> o));
        int L = 0;
        int R = arr.size() - 1;
        while (L < R) {
            if (arr.get(L) + arr.get(R) == value) {
                return true;
            } else if (arr.get(L) + arr.get(R) > value) {
                R--;
            } else {
                L++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        System.out.println(twoSum2.find(0));
    }

}

