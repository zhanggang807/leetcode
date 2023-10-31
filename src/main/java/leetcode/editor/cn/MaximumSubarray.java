package leetcode.editor.cn;

/**
 * 题目标题 最大子数组和
 * 题目标记 maximum-subarray
 * 题目编号 53
 * 时间 2023-10-31 12:38:17
 * 已提交
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
    /*
        这道题还是用的动态规划，但是我感觉用滑动窗口也行吧
        题目只要求返回结果，不要求得到最大的连续子数组是哪一个。这样的问题通常可以使用「动态规划」解决。

        这个题还是重要分析过程，不是思路型问题，差在这方面了

        以i为结尾的前面的和是多少，感觉跟滑动窗口好像啊
     */

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
            int[] dp = new int[len];
            dp[0] = nums[0];

            for (int i = 1; i < len; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
            }

            // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
            int res = dp[0];
            for (int i = 1; i < len; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
