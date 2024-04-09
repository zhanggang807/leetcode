package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目标题 和为 K 的子数组
 * 题目标记 subarray-sum-equals-k
 * 题目编号 560
 * 时间 2023-10-24 16:53:54
 * 已提交
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        int[] nums = new int[]{1, 2, 3};
        int k = 3;
        System.out.println(solution.subarraySum(nums, k));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 前缀和+哈希表 优化
         * 前缀和数组的定义，这里理解这个很重要，给定一个数组，生成前缀和的算法是
         * 这个数组的下一个位置的值是前面所有值的和，例子：[1，2，3]，会生成[1, 3, 6]
         */
        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                // 最重要的if判断，如果出现了指定值说明了，之前前缀和中已有目标数值所以增加计数
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
