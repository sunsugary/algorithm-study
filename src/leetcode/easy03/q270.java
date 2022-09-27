package leetcode.easy03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: 最接近的二叉搜索树值
 * @Author: 5753
 * @Date: 2022/9/26 17:24
 * @Description: TODO
 */
public class q270 {
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

    public int closestValue(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return Collections.min(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
    }

    private void process(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }

    //二分法
    public int closestValue2(TreeNode root, double target) {
        int ans = root.val;
        int cur;
        while (root != null) {
            cur = root.val;
            //当前遍历到的节点的值与目标值的差值是否更小，更小则更新ans
            ans =  Math.abs(cur - target) < Math.abs(ans - target) ? cur : ans;
            //当前遍历到的节点的值小于目标值，则下一次循环从右子树开始，反之从左子树开始
            root = root.val < target ? root.left : root.right;
        }
        return ans;
    }

}
