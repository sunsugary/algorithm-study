package begin.Demo02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Code05 {
    /**
     * 时间复杂度
     * 等差数列求和公式
     * Sn = na1 + ( n(n-1)/2 ) * d
     *
     * 冒泡排序的时间复杂度为n^2
     *
     * 固定数组：数组长度不能改变的数组
     * 动态数组：数组可以进行扩容的数组
     *
     * 扩容行为是否会增加时间复杂度
     * ArrayList 扩容的时间复杂度为（N/N）
     */

    public static class Node{

        private Integer i ;
        public Node(Integer i){
            this.i = i;
        }
    }
    /**
     * hash表
     *
     */
    public static void main(String[] args) {
        /**
         * hash表的增删改查是固定时间 时间复杂度为（1）
         *
         * hashmap的key如果是jdk原生数据类型则为值传递
         * 如果是自定义类型为key则是引用传递
         */
        HashMap<String,String> map = new HashMap<>();
        Integer i = 1;
        Node node1 = new Node(1);
        TreeMap<Node,String> treeMap = new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return node.i > t1.i ? 0 : 1;
            }
        });
        treeMap.put(node1,"我是node1");



    }
}
