package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目标题 颜色分类
 * 题目标记 sort-colors
 * 题目编号 75
 * 时间 2023-10-26 17:26:56
 * 已提交
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
        这题竟然可以这样做，因为值都是固定的0，1，2 红白蓝
        按0，1依次交换位置即可
     */

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
            for (int i = ptr; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
