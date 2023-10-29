package leetcode.editor.cn;

/**
 * 题目标题 搜索插入位置
 * 题目标记 search-insert-position
 * 题目编号 35
 * 时间 2023-10-27 16:33:42
 * 已提交
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();

        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 左闭右闭的二分查找写法，目标插入位置满足nums[i] < target <= nums[i+1]
         */
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0;
            int right = nums.length - 1;
            int ans = nums.length;

            while (left <= right) {
                int mid = left + (right - left) / 2;// 防止溢出
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target <= nums[mid]) {
                    ans = mid;
                    right = mid - 1;
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
