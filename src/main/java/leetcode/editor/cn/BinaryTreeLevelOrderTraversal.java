package leetcode.editor.cn;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

import java.util.*;

/**
 * 题目标题 二叉树的层序遍历
 * 题目标记 binary-tree-level-order-traversal
 * 题目编号 102
 * 时间 2023-10-10 16:46:59
 * 已提交
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);// 可能直接打印出来这种格式 [[3], [9, 20], [15, 7]]

        /*
         看了解决方法之后，发现这个跟之前做的那个层次遍历只要要求打印出来，还是有点不一样的
         public void levelTravel(TreeNode root) {
             if (root == null) {
                 return;
             }
             Queue<TreeNode> queue = new LinkedList<>();
             queue.offer(root);
             while (!queue.isEmpty()) {
                 TreeNode node = queue.poll();
                 System.out.print(node.val + " ");
                 if (node.left != null) {
                     queue.offer(node.left);
                 }
                 if (node.right != null) {
                     queue.offer(node.right);
                 }
             }
         }
         要具体区分出来 节点都是在哪一层被打印的，需要 优化一下上面的代码也就是leetcode solution里的答案
         本次实现使用这个方法，还有一个更好理解的方法，没有使用队列特性的方法，见下方代码
         class Solution {
             public List<List<Integer>> levelOrder(TreeNode root) {
                 // 边界判断
                 if(root == null)
                     return new ArrayList<>();

                 List<List<Integer>> resListList = new ArrayList<>();  // 记录结果
                 List<TreeNode> currLevelNode = new ArrayList<>(); // 记录每一层的 node
                 currLevelNode.add(root); // 录入第一层的node

                 while (!currLevelNode.isEmpty()){
                     // 记录层的值
                     List<Integer> currLevel = new ArrayList<>();
                     // 记录下层的node
                     List<TreeNode> tns = new ArrayList<>();
                     currLevelNode.forEach(e->{
                         currLevel.add(e.val);
                         if(e.left!=null)
                             tns.add(e.left);
                         if(e.right!=null)
                             tns.add(e.right);
                     });
                     resListList.add(currLevel);
                     currLevelNode = tns;
                 }
                 return resListList;
             }
         }
        */

    }

    // Queue 接口方法区别
    // 	抛出异常         返回特殊值
    // 插入	add(e)   	offer(e)
    // 移除	remove()	poll()
    // 检查	element()	peek()

    static class TreeNode {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> currentLevel = new ArrayList<>();

                // 这for循环相当有道理呀，队列里添加了几个就表示当前层有几个！简单层次遍历的加强版
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    currentLevel.add(poll.val);

                    TreeNode left = poll.left;
                    if (left != null) {
                        queue.offer(left);
                    }

                    TreeNode right = poll.right;
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                res.add(currentLevel);
            }

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
