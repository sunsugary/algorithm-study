package begin.Demo02;

public class Code01 {

    public static class Node{
        public int val;
        public Node( int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);

        Node node2 = node1;

        node2.val = 3;

        System.out.println(node1.val+","+node2.val);

    }
}
