package begin.Demo03;

public class Code04_ReverseNodesInKGroup {
    /**
     * K个节点的组内逆序调整问题：
     * 给定一个单链表的头节点head，和一个正数k
     * 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
     * 例子:
     * 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3
     * 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
     */

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head,int k){
        ListNode start = head;
        ListNode end = getKNode(start,k);
        //当节点数不够K个时
        if (end == null) {
            return head;
        }
        //第一组的尾节点新链表的头节点
        head = end;
        //反转第一组的节点
        reverse(start,end);
        //上一组的尾节点需要链接下一组的头节点
        ListNode lastEnd = start;
        //判断上一组的尾节点后是否还有节点
        while (lastEnd.next != null){
            //第二组要进行反转，那么开始节点只能时上一组的尾节点的下一个节点
            start = lastEnd.next;
            end = getKNode(start,k);
            if (end == null) {
                return head;
            }
            //反转第二组链表
            reverse(start,end);
            //上一组的尾节点应该连向第二组反转前的尾节点
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;

    }



    //给定一个链表的某个节点作为开始节点 返回第k个节点
    public static ListNode getKNode(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    //给定链表的开始节点和结束节点，将该段链表反转,原链表的头部与下一组的头部相连
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = start;

        while (cur != end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;

    }


}
