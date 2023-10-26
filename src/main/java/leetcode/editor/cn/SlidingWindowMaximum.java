package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目标题 滑动窗口最大值
 * 题目标记 sliding-window-maximum
 * 题目编号 239
 * 时间 2023-10-26 10:57:40
 * 已提交
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return new int[0];
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            // 未形成窗口
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && deque.peekLast() < nums[i])
                    deque.removeLast();
                deque.addLast(nums[i]);
            }
            res[0] = deque.peekFirst();
            // 形成窗口后
            for (int i = k; i < nums.length; i++) {
                // 相等判断也很重要
                if (deque.peekFirst() == nums[i - k])
                    deque.removeFirst();
                while (!deque.isEmpty() && deque.peekLast() < nums[i])
                    deque.removeLast();
                deque.addLast(nums[i]);
                res[i - k + 1] = deque.peekFirst();
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
