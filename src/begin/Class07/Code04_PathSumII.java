package begin.Class07;

import java.util.ArrayList;
import java.util.List;

public class Code04_PathSumII {
    // 测试链接：https://leetcode.com/problems/path-sum-ii
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(root, path, 0, targetSum, ans);
        return ans;
    }

    private void process(TreeNode root, List<Integer> path, int preSum, int targetSum, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (targetSum == (preSum + root.val)) {
                path.add(root.val);
                //ans.add(path);这个相当于是把path的内存地址给了ans，此时后续如果我对path进行变动将会改变ans的结果
                ans.add(new ArrayList<>(path));
                //如果右节点也满足,所以当前这个路径需要返回给上一层节点用的
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        preSum += root.val;

        if (root.left != null) {
            process(root.left, path, preSum, targetSum, ans);
        }
        if (root.right != null) {
            process(root.right, path, preSum, targetSum, ans);
        }
        //如果一个节点的左右节点都调完了
        //此时递归调用结果返回给上一个节点
        path.remove(path.size() - 1);
    }

//    private List<Integer> processs() {
//        List<Integer> curPath = new ArrayList<>();
//        curPath.add(root.val);
//        if (root.left == null && root.right == null) {
//            if (targetSum == (preSum += root.val)) {
//                return curPath;
//            }
//        }
//
//        preSum += root.val;
//
//        if (root.left != null) {
//            process(root.left, preSum, targetSum);
//        }
//        if (root.right != null) {
//            process(root.right, preSum, targetSum);
//        }
//        return null;
//    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        path.add(1);
        path.add(2);
        path.add(3);
        path.add(4);
        ans.add(path);

        for (List<Integer> an : ans) {
            for (Integer integer : an) {

                System.out.println(integer);
            }
        }
        path.remove(path.size() - 1);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {

                System.out.println(integer);
            }
        }
    }
}
