package begin.Class06;

import java.util.*;

public class ShowComparator {

    /**
     * 如果两个字符串调用compareTO方法 按照字典序来比较
     * 1.如果两个字符串的length一样，则按照字面顺序比较，则a>b
     * 2.如果两个字符串的length不一样，则将短的补码，补最低的ascii码
     */

    public static class MyComparator implements Comparator<Integer> {


        /**
         // 如果返回负数，认为第一个参数应该排在前面
         // 如果返回正数，认为第二个参数应该排在前面
         // 如果返回0，认为谁放前面无所谓
         */
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }

    public static void main(String[] args) {
        MyComparator myComparator = new MyComparator();
        TreeSet<Integer> treeSet = new TreeSet<>(myComparator);
        TreeMap<String,Object> treeMap = new TreeMap<>((o1, o2) -> 0);
        Integer arr[] = {1,2,3,4,5};
        Arrays.sort(arr,myComparator);

        List<Integer> list = new ArrayList<>();



    }


}
