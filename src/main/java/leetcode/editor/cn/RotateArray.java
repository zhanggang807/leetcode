package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目标题 轮转数组
 * 题目标记 rotate-array
 * 题目编号 189
 * 时间 2023-10-26 12:35:42
 * 已提交
 */
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        System.out.println(3 % 7);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 原始数组          1 2 3 4 5 6 7
         * 翻转所有元素       7 6 5 | 4 3 2 1
         * 翻转0到k%n的元素   5 6 7 | 4 3 2 1
         * 翻转k到n的元素     5 6 7 | 1 2 3 4
         */
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
