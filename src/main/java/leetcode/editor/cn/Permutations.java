package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目标题 全排列
 * 题目标记 permutations
 * 题目编号 46
 * 时间 2023-10-17 16:13:27
 * 已提交
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permuteList = solution.permute(nums);
        for (List<Integer> permute : permuteList) {
            System.out.println(permute);
        }

        /* 输出结果
         [1, 2, 3]
         [1, 3, 2]
         [2, 1, 3]
         [2, 3, 1]
         [3, 1, 2]
         [3, 2, 1]
        */

        /*
        回溯算法:全排列_全排列回溯算法_从头再来yyds的博客-CSDN博客
        https://blog.csdn.net/m0_51436734/article/details/124082089

        回溯算法 决策树遍历 框架
        result = []
        def backtrack(路径, 选择列表):
            if 满足结束条件:
                result.add(路径)
                return

            for 选择 in 选择列表:
                做选择
                backtrack(路径, 选择列表)
                撤销选择
        */
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            // 回溯所用路径记录 和 visited数组
            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[len];

            // 开始遍历
            dfs(nums, len, 0, path, used, res);
            return res;
        }

        /**
         * 深度优先
         */
        public void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
            // 深度到达最大，触发递归返回
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                // 排除不合法的选择
                if (used[i]) {
                    continue;
                }
                // 递归前 选择
                path.addLast(nums[i]);
                used[i] = true;
                // 递归，进入下一层决策树
                dfs(nums, len, depth + 1, path, used, res);
                // 递归后 取消选择
                path.removeLast();
                used[i] = false;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
