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

        递归：去的过程叫“递”，回来的过程叫“归”
        写递归代码的关键就是找到如何将大问题分解为小问题的规律，并且基于此写出递推公式
        然后再推敲终止条件，最后将递推公式和终止条件翻译成代码
        人脑几乎没办法把整个“递”和“归”的过程一步一步都想清楚
        这种试图想清楚整个递和归过程的做法，实际上是进入了一个思维误区
        因此，编写递归代码的关键是，只要遇到递归，我们就把它抽象成一个递推公式
        不用想一层层的 调用关系，不要试图用人脑去分解递归的每个步骤，屏蔽掉递归细节
        正确姿势是写出 递推公式，找出终止条件，然后再翻译成递归代码
        需要满足条件：一个问题分解为子问题，子问题求解思路完全相同，存在递归退出条件
        避免死循环，避免栈溢出，避免重复计算，改成非递归有时徒增复杂度而已，只是自己实现了栈，还不如直接借用jvm或者底层的实现
        空间复杂度高、有堆栈溢出的风险、存在重复计算、过多的函数会耗时较多等问题

        好问题：层次比较深的递归代码在idea里不好调试，如何解决呢？？
        调试递归：
        1、打印日志发现，递归值。
        2、结合条件断点进行调试。
        调试递归就像写递归一样，不要被每一步的细节所困，重点在于确认递推关系与结束条件是否正确
        用条件断点着重调试最初两步与最终两步即可。


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
            // 换成LinkedList也行，add 和 removeLast配合使用
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
