package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目标题 二叉树的中序遍历
 * 题目标记 binary-tree-inorder-traversal
 * 题目编号 94
 * 时间 2023-10-19 13:27:56
 * 已提交
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        // 官方demo示例
        // TreeNode root = new TreeNode(1);
        // TreeNode right = new TreeNode(2);
        // root.right = right;
        // right.left = new TreeNode(3);

        // 来个满二叉树
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;

        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        // 来一个递归的 中序遍历 非常简单
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        System.out.println(solution.inorderTraversal(root));

        System.out.println("--------------------------------------");

        // 来一个非递归的 迭代版本的 中序遍历，稍复杂点
        Solution2 solution2 = new BinaryTreeInorderTraversal().new Solution2();
        System.out.println(solution2.inorderTraversal(root));
        // [4, 2, 5, 1, 6, 3, 7]
    }

    /*
                         ---
                        | 1 |
                         ---
                     /         \
                   ---         ---
                  | 2 |       | 3 |
                   ---         ---
                 /     \      /    \
                ---    ---   ---   ---
               | 4 |  | 5 | | 6 | | 7 |
                ---    ---   ---   ---
     */


    /**
     * 迭代版本，非递归版本
     */
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode node = root;
            Stack<TreeNode> st = new Stack<>();
            // 节点不为空或栈内有节点时，说明还有节点未遍历
            while (!st.isEmpty() || node != null) {
                // 中序遍历，优先遍历当前node为根的子树的最左侧节点
                while (node != null) {
                    st.push(node);
                    node = node.left;
                }
                node = st.pop();    // 获取当前节点
                res.add(node.val);
                node = node.right;  // 遍历node的右子树
            }
            return res;
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            midOrder(root, list);
            return list;
        }

        public void midOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
