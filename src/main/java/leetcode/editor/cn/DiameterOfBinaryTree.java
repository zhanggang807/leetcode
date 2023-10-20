package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目标题 二叉树的直径
 * 题目标记 diameter-of-binary-tree
 * 题目编号 543
 * 时间 2023-10-19 17:31:09
 * 已提交
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        System.out.println(solution.diameterOfBinaryTree(root));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) return -1; // 下面 +1 后，对于叶子节点就刚好是 0
            int lLen = dfs(node.left) + 1; // 左子树最大链长+1
            int rLen = dfs(node.right) + 1; // 右子树最大链长+1
            ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
            return Math.max(lLen, rLen); // 当前子树最大链长
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}
