package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目标题 移动零
 * 题目标记 move-zeroes
 * 题目编号 283
 * 时间 2023-10-23 14:34:02
 * 已提交
 */
public class MoveZeroes {
    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        // Solution solution = new MoveZeroes().new Solution();
        // solution.moveZeroes(nums);
        Solution2 solution2 = new MoveZeroes().new Solution2();
        solution2.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 借助了快排的思想
     */
    class Solution2 {
        public void moveZeroes(int[] nums) {
            if(nums==null) {
                return;
            }
            //两个指针i和j
            int j = 0;
            for(int i=0;i<nums.length;i++) {
                //当前元素!=0，就把其交换到左边，等于0的交换到右边
                if(nums[i]!=0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;
                }
            }
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这个二次遍历的解法确实不用再开空间，也毕竟容易理解
         */
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }
            // 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
            int j = 0;
            // 双指针在这里有一个很好的备忘的作用
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }
            // 非0元素统计完了，剩下的都是0了
            // 所以第二次遍历把末尾的元素都赋为0即可
            for (int i = j; i < nums.length; ++i) {
                nums[i] = 0;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
