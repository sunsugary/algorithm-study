package leetcode.easy;

public class q108 {
    public static class TreeNode {
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

        public TreeNode sortedArrayToBST(int[] nums) {
            return process(nums, 0, nums.length - 1);
        }

        private TreeNode process(int[] nums, int L, int R) {
            if (L > R) return null;
            int mid = L + ((R - L) >> 1);
            TreeNode head = new TreeNode(nums[mid]);
            head.left = process(nums, L, mid - 1);
            head.right = process(nums, mid + 1, R);
            return head;
        }

    }
}
