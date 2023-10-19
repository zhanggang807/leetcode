package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目标题 二叉树的最大深度
 * 题目标记 maximum-depth-of-binary-tree
 * 题目编号 104
 * 时间 2023-10-19 14:27:55
 * 已提交
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        // 官方demo示例
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        // 来个满二叉树
        // TreeNode root = new TreeNode(1);
        // TreeNode left = new TreeNode(2);
        // root.left = left;
        // TreeNode right = new TreeNode(3);
        // root.right = right;
        //
        // left.left = new TreeNode(4);
        // left.right = new TreeNode(5);
        //
        // right.left = new TreeNode(6);
        // right.right = new TreeNode(7);

        // 深度优化遍历
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        System.out.println(solution.maxDepth(root));

        // 再来个就广度优化遍历，基本意思就是改一下层次遍历的代码
        Solution2 solution2 = new MaximumDepthOfBinaryTree().new Solution2();
        System.out.println(solution2.maxDepth(root));
    }


    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int maxDep = 0;
            Queue<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                // 这while循环相当有道理呀，队列里添加了几个就表示当前层有几个！简单层次遍历的加强版
                while (size-- > 0) {
                    TreeNode poll = deque.poll();
                    System.out.println(poll);
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
                // 上面那个while循环把左右子节点都加了，才算进入下一层，所以层数加1
                maxDep++;
            }
            return maxDep;
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
        public int maxDepth(TreeNode root) {
            // 递归退出条件
            if (root == null) {
                return 0;
            }
            // 递归计算左右子树的深度，这里 +1 很重要，不要忘了
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
