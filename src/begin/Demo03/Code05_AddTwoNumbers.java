package begin.Demo03;

public class Code05_AddTwoNumbers {
    /**
     * 两个链表相加问题
     * 给定两个链表的头节点head1和head2，
     * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
     * 例子     4 -> 3 -> 6        2 -> 5 -> 3
     * 返回     6 -> 8 -> 9
     * 解释     634 + 352 = 986
     */

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        int length1 = listLength(node1);
        int length2 = listLength(node2);
        ListNode l = length1 >= length2 ? node1 : node2;
        ListNode s = l == node1 ? node2 : node1;
        ListNode curL = l;
        ListNode curS = s;
        //进位信息
        int carry = 0;
        int curNum = 0;
        //记录最后一个节点，因为当长链和短链同时为空的时候需要判断是否还有进位
        ListNode last = curL;

        //首先当短链表不为空时
        while (curS != null) {
            curNum = curS.val + curL.val + carry;
            carry = curNum / 10;
            curNum = curNum % 10;
            last = curL;
            curL.val = curNum;
            curS = curS.next;
            curL = curL.next;
        }

        //走到这一步说明短链表已经为空了，
        while (curL != null) {
            curNum = curL.val + carry;
            carry = curNum / 10;
            curNum = curNum % 10;
            last = curL;
            curL.val = curNum;
            curL = curL.next;
        }

        //最后当长链表也走完了 判断是否还有进位信息 如果有则生成一个新的节点

        if (carry != 0) {
            last.next = new ListNode(1);
        }

        return l;

    }


    //计算链表的长度
    public static int listLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1, new ListNode(2,new ListNode()));

    }


}
