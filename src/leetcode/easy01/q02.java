package leetcode.easy01;

/**
 * @ClassName: q02
 * @Author: 5753
 * @Date: 2022/9/19 12:55
 * @Description: TODO
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class q02 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        ListNode l = length1 > length2 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;
        ListNode cur1 = l;
        ListNode cur2 = s;
        int a = 0; //进位信息
        int val = 0; //和
        ListNode last = cur1;
        while (cur2 != null) {
            val = cur1.val + cur2.val + a;
            a = val / 10;
            val =  val % 10;
            cur1.val = val;
            last = cur2;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null){
            val = cur1.val + a;
            a = val / 10;
            val = val % 10;
            cur1.val = val;
            last = cur1;
            cur1 = cur1.next;
        }
        if (a > 0 ){
            last.next = new ListNode(1);
        }

        return l;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
