package basic.Class09;

/**
 * @ClassName: Code03_SmallerEqualBigger
 * @Author: 5753
 * @Date: 2022/9/18 11:30
 * @Description: 给一个链表的头节点，给定一个目标值K，判断小于k的放在左边，等于k的放在中间，大于k的放在右边。
 */
public class Code03_SmallerEqualBigger {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //使用数组的方式
    public static Node listPartition(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        Node[] arr = new Node[length];

        cur = head;
        int index = 0;
        while (cur != null) {
            arr[index++] = cur;
            cur = cur.next;
        }
        arrPartition(arr, pivot);

        //重新将数组组成链表
        for (int i = 0; i < arr.length; i++) {
            arr[i].next = arr[i + 1];
        }
        arr[arr.length -1].next = null;
        return arr[0];

    }

    private static void arrPartition(Node[] arr, int pivot) {
        int index = 0;
        int small = -1;
        int big = arr.length;

        while (index < big) {
            if (arr[index].value < pivot) {
                swap(arr, ++small, index++);
            } else if (arr[index].value == pivot) {
                index++;
            } else {
                swap(arr, --big, index);
            }
        }
    }

    public static void swap(Node[] arr, int k, int m) {
        Node temp = arr[k];
        arr[k] = arr[m];
        arr[m] = temp;

    }


    public static Node listPartition2(Node head, int pivot) {
        //定义6个指针
        Node sH = null; //小头
        Node sT = null; //小尾
        Node eH = null; //等头
        Node eT = null; //等尾
        Node mH = null; //大头
        Node mT = null; //大尾
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }

            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            // 小于区和等于区必有一个
            eT.next = mH;
        }

        return sH != null ? sH : eH != null ? eH : mH;


    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
         head1 = listPartition(head1, 5);
//        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }


}
