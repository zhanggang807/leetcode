package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目标题 三数之和
 * 题目标记 3sum
 * 题目编号 15
 * 时间 2023-10-24 16:20:57
 * 已提交
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 都要先排序好处理
            int n = nums.length;
            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 枚举 a
            for (int first = 0; first < n; ++first) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                int target = -nums[first];
                // 枚举 b
                for (int second = first + 1; second < n; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
