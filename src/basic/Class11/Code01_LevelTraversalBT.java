package basic.Class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Code01_LevelTraversalBT
 * @Author: 5753
 * @Date: 2022/9/23 21:28
 * @Description: BFS breath first search
 */
public class Code01_LevelTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }


    public static void bfs(Node head){
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }

}
