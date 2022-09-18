package begin.Demo03;

public class Code06_MergeTwoSortedLinkedList {
    /**
     * 两个有序链表的合并
     * 给定两个有序链表的头节点head1和head2，
     * 返回合并之后的大链表，要求依然有序
     * 例子     1 -> 3 -> 3 -> 5 -> 7   2 -> 2 -> 3 -> 3-> 7
     * 返回     1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
     */

    /**
     * 因为两个子链表是有序的，第一个节点进行相比，更小的排第一个，其次排第二个，此时需要记住排第二个的节点。
     * 第二个节点相比，更小的排第一个且上一个节点排第二个的需要链接更小的节点
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


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //首先进来判断两个链表是否为空
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = list1.val <= list2.val ? list1 : list2;

        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;

        ListNode pre = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            }else{
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }

        pre.next =  cur1 == null ? cur2 :   cur1;
        return head;

    }


}
