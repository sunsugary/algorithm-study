package basic.Class01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Code07_EvenTimesOddTimes {

    //arr中，只有一种数出现了奇数次，其他数出现了偶数次，找到这个数

    /**
     * 使用Map表做词频统计
     *
     * @param arr
     */
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int ans = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    /**
     * 使用位运算来找到出现奇数次的数
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println("找到出现奇数次的数啦！！！！它就是：" + eor);
    }


    /**
     * arr中有两个数a,b出现了奇数次，其他数都出现了偶数次，求a,b
     *
     * @param arr
     */
    public static void printOddTimesNum3(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        /**
         * 得到的eor肯定是 a^b
         * 分析a^b 二进制位最右边为1的那一位（R） 说明 a 和 b的R位肯定不相同，则一个为1一个为0
         * 如果按照这个规则在arr数组中所有数的二进制位的R位上为0的和为1的分开放在两个集合中，那么此时一定能将a和b两个数分开
         * 现在有两个结合C1，C0,假设C0是存放R位上是0的数，C1是存放R位上是1的数
         * 将C1集合里面的数全部进行^运算 最终得到一个数字，这个数就是a和b其中一个
         * 由于已经知道了a^b的结果，那么只要再^上其中一个数，就能得到另外一个数
         */

        //拿到eor二进制位最右边为1的位置R
        /**
         * 怎么取到最右边为1的位置R
         * 需要将除R位上所有的数变成0，只留R位是1
         * a & ( ~a + 1)  = a & -a
         */
        int numR = eor & -eor;


        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & numR) != 0) {
                a ^= arr[i];
            }
        }
        int b = eor ^ a;
        System.out.println("找到出现奇数次的数啦！！！a = " + a + " ,b= " + b);
    }

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & 1 << i) == 0 ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        int kinds = 100;
        int range = 300;
        int times = 100000;
        int max = 9;
        System.out.println("测试开始！");
        for (int i = 0; i < times; i++) {
            int a = (int) (Math.random() * max) + 1;
            int b = (int) (Math.random() * max) + 1;

            int m = Math.max(a, b);
            int k = Math.min(a, b);
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);

            int test = test(arr, k, m);
            int i1 = printOddTimesNum4(arr, k, m);

            if (test != i1) {
                System.out.println("oops!");
            }


        }
        System.out.println("测试结束！");

    }

    private static int[] randomArray(int maxKinds, int range, int k, int m) {
        //出现k次的数
        int kNum = randomNumber(range);
        int kTimes = k;
        //最低需要两种数
        int kindsNum = (int) (Math.random() * maxKinds) + 2;

        //数组的长度 (kindsNum - 1) * m 总种类减去出现k次的那个数的种类其余都是出现m次的数
        int[] arr = new int[kTimes + (kindsNum - 1) * m];

        //将k次数添加到数组中
        int index = 0;
        for (; index < kTimes; index++) {
            arr[index] = kNum;
        }

        //种类减1
        kindsNum--;

        //其余出现m次数的每一种数都不能重复
        Set<Integer> set = new HashSet<>();
        //将k次数添加进set
        set.add(kNum);
        while (kindsNum != 0) {
            //直到所有种类都添加到数组
            int curNum = 0;
            do {
                //保证出现m次数的每一种不能重复
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            kindsNum--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }

        //生成最终的arr，但是需要打乱这个数组，进行随机交换
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;

    }

    // 为了测试
    // [-range, +range]
    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }

    /**
     * 题：给一个数组arr,给两个常量k,M，这个数组中，有一个数出现了K次，其他数出现了M次 并且M不等1，K < M，找到出现K次的这个数
     */
    public static int printOddTimesNum4(int[] arr, int K, int M) {

        //定义一个数组，数组长度为32，每个数的二进制位如果是1则将数组对应位置上加1
        int[] temp = new int[32];
//        for (int num : arr) {
//            for (int i = 0; i < 32; i++) {
//                if (((num >> i) & 1) != 0) {
//                    temp[i]++;
//                }
//            }
//        }

        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                //(num >> i) & 1 只有两种结果0或1
                temp[i] += (num >> i) & 1;
//                if (((num >> i) & 1) != 0) {
//                    temp[i]++;
//                }
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 31; j >= 0; j--) {
//                if ((arr[i] & (1 << j)) != 0) {
//                    temp[j]++;
//                }
//            }
//        }
        int a = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] % M == 0) {
                continue;
            }

            if (temp[i] % M == K) {
//                a += Math.pow(2, i);
                //一个数左移n位相当于乘以2的n次方
                //一个数右移n位相当于除以2的n次方
                a |= 1 << i;
            } else {
                return -1;
            }
        }
        return a;

    }

}
