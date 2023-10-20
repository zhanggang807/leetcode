package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;

/**
 * 题目标题 翻转二叉树
 * 题目标记 invert-binary-tree
 * 题目编号 226
 * 时间 2023-10-19 15:02:37
 * 已提交
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        // 递归深度优化
        TreeNode treeNode = solution.invertTree(root);

        // 再来个广度优先 迭代方式
        Solution2 solution2 = new InvertBinaryTree().new Solution2();
        TreeNode treeNode2 = solution2.invertTree(root);
    }

    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                // 每次都从队列中拿一个节点，并交换这个节点的左右子树
                TreeNode tmp = queue.poll();
                TreeNode left = tmp.left;
                tmp.left = tmp.right;
                tmp.right = left;
                // 如果当前节点的左子树不为空，则放入队列等待后续处理
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                // 如果当前节点的右子树不为空，则放入队列等待后续处理
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            // 返回处理完的根节点
            return root;
        }
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
        public TreeNode invertTree(TreeNode root) {
            // 递归函数的终止条件，节点为空时返回
            if (root == null) {
                return null;
            }
            // 下面三句是将当前节点的左右子树交换
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            // 递归交换当前节点的 左子树
            invertTree(root.left);
            // 递归交换当前节点的 右子树
            invertTree(root.right);
            // 函数返回时就表示当前这个节点，以及它的左右子树
            // 都已经交换完了
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
