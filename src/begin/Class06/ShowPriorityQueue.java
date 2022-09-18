package begin.Class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShowPriorityQueue {

    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args) {
        //优先级队列，其实为堆
        //他会按照从小到大的顺序弹出
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        heap.add(312);
        heap.add(3);
        heap.add(234);
        heap.add(55);
        heap.add(546);
        heap.add(8345);
        heap.add(3154356);

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }


    }


}
