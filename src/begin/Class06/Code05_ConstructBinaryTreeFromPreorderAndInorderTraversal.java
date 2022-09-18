package begin.Class06;

import java.util.HashMap;
import java.util.Map;

public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode buildTree(int[] pre, int[] in) {

        //首先两个数组不能为空，其次两个数组长度要相同

        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        //用一个MAP存中序遍历结果的节点index
        Map<Integer, Integer> inIndexMap = inMap(in);


        return f(pre, 0, pre.length - 1, in, 0, in.length - 1, inIndexMap);


    }

    private TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2, Map<Integer, Integer> inIndexMap) {

        if (L1 > R1) {
            return null;
        }
        TreeNode headNode = new TreeNode(pre[L1]);

        if (L1 == R1) {
            return headNode;
        }

        Integer find = inIndexMap.get(pre[L1]);


        headNode.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, inIndexMap);
        headNode.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, inIndexMap);

        return headNode;


    }

    private Map<Integer, Integer> inMap(int[] in) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;


    }


}
