package leetcode.editor.cn;

/**
 * 题目标题 多数元素
 * 题目标记 majority-element
 * 题目编号 169
 * 时间 2023-10-26 17:00:16
 * 已提交
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};

        int i = solution.majorityElement(nums);
        System.out.println(i);// n/2=7/2=3 2出现4次，所以结果是2
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 摩尔投票算法 核心理念为 票数正负抵消，是我的票就加1，不是我的就减1，减到0就换人了，重复此过程
         * 初始化： 票数统计 votes = 0 ， 众数 x。
         * 循环： 遍历数组 nums 中的每个数字 num 。
         * 当 票数 votes 等于 0 ，则假设当前数字 num 是众数。
         * 当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 。
         * 返回值： 返回 x 即可。
         */
        public int majorityElement(int[] nums) {
            int x = 0, votes = 0;
            for (int num : nums) {
                if (votes == 0) x = num;
                votes += num == x ? 1 : -1;
            }
            return x;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
