package begin.Class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_MergeKSortedLists {
    /**
     * 合并多个有序链表
     * 5 -> 7 -> 9
     * 1 -> 3 -> 6
     * 3 -> 4 -> 8
     * <p>
     * 结果：1 -> 3 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class MyComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }


        //小根堆必需要传入比较方法
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new MyComparator());

        for (ListNode list : lists) {
            if (list != null){
                heap.add(list);
            }
        }

        if (heap.isEmpty()) {

            return null;
        }


        ListNode head = heap.poll();
        ListNode pre = head;

        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {

            ListNode poll = heap.poll();
            pre.next = poll;
            pre = poll;
            if (poll.next != null) {
                heap.add(poll.next);
            }
        }
        return head;
    }


}
