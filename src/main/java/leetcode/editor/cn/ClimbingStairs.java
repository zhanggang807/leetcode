package leetcode.editor.cn;

/**
 * 题目标题 爬楼梯
 * 题目标记 climbing-stairs
 * 题目编号 70
 * 时间 2024-03-29 13:11:15
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        int steps = solution.climbStairs(5);
        System.out.println(steps);
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }

            int first = 1;
            int second = 2;
            for (int i = 3; i <= n; i++) {
                int third = first + second;
                first = second;
                second = third;

            }

            return second;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
