package leetcode.editor.cn;

/**
 * 题目标题 找出数组的串联值
 * 题目标记 find-the-array-concatenation-value
 * 题目编号 2562
 * 时间 2023-10-12 15:42:09
 * 已提交
 */
public class FindTheArrayConcatenationValue {
    public static void main(String[] args) {
        Solution solution = new FindTheArrayConcatenationValue().new Solution();
        int[] nums = new int[]{5, 14, 13, 8, 12};
        long theArrayConcVal = solution.findTheArrayConcVal(nums);
        System.out.println(theArrayConcVal);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            long result = 0;
            boolean hasMiddle = nums.length % 2 != 0;
            int middleIndex = nums.length / 2;
            // 双指针解决，头尾一起遍历
            for (int i = 0, j = nums.length - 1; i < middleIndex; i++, j--) {
                int first = nums[i];
                int last = nums[j];
                result += Long.parseLong("" + first + last);
            }

            // 最后再计算中间的一个元素
            if (hasMiddle) {
                result += nums[middleIndex];
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
