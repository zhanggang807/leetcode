package leetcode.editor.cn;

/**
 * 题目标题 只出现一次的数字
 * 题目标记 single-number
 * 题目编号 136
 * 时间 2023-10-26 16:40:36
 * 已提交
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] nums = new int[]{1, 1, 2, 3, 2, 3, 4};
        solution.singleNumber(nums);
    }
    /*
        1 ^ 1
        ans = 0
        0 ^ 2
        ans = 2
        2 ^ 3
        ans = 1
        1 ^ 2
        ans = 3
        3 ^ 3
        ans = 0
        0 ^ 4
        ans = 4
     */

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用异或运算
         */
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            if (nums.length > 1) {
                for (int i = 1; i < nums.length; i++) {
                    // System.out.println(ans + " ^ " + nums[i]);
                    ans = ans ^ nums[i];
                    // System.out.println("ans = " + ans);
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
