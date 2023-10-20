package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;

/**
 * 题目标题 对称二叉树
 * 题目标记 symmetric-tree
 * 题目编号 101
 * 时间 2023-10-19 15:17:16
 * 已提交
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(2);
        root.right = right;

        left.left = new TreeNode(3);
        left.right = new TreeNode(4);

        right.left = new TreeNode(4);
        right.right = new TreeNode(3);

        // 递归
        System.out.println(solution.isSymmetric(root));

        // 迭代
        Solution2 solution2 = new SymmetricTree().new Solution2();
        System.out.println(solution2.isSymmetric(root));
    }

    /**
     *
     */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            // 用队列保存节点
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            // 将根节点的左右孩子放到队列中
            queue.add(root.left);
            queue.add(root.right);
            while (!queue.isEmpty()) {
                // 从队列中取出两个节点，再比较这两个节点
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();
                // 如果两个节点都为空就继续循环，两者有一个为空就返回false
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                // 将左节点的左孩子， 右节点的右孩子放入队列
                queue.add(left.left);
                queue.add(right.right);
                // 将左节点的右孩子，右节点的左孩子放入队列
                queue.add(left.right);
                queue.add(right.left);
            }

            return true;
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 调用递归函数，比较左节点，右节点
            return dfs(root.left, root.right);
        }

        boolean dfs(TreeNode left, TreeNode right) {
            // 递归的终止条件是两个节点都为空
            // 或者两个节点中有一个为空
            // 或者两个节点的值不相等
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            // 再递归的比较 左节点的左孩子 和 右节点的右孩子
            // 以及比较  左节点的右孩子 和 右节点的左孩子
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
