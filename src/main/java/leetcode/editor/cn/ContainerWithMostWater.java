package leetcode.editor.cn;

/**
 * 题目标题 盛最多水的容器
 * 题目标记 container-with-most-water
 * 题目编号 11
 * 时间 2023-10-23 15:05:26
 * 已提交
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));

        Solution2 solution2 = new ContainerWithMostWater().new Solution2();
        System.out.println(solution2.maxArea(height));
    }

    class Solution2 {
        /**
         * 真正的双指针解决，感觉跟下面的解决差不多呀，只是换了个形式
         */
        public int maxArea(int[] height) {
            int res = 0;
            int i = 0;
            int j = height.length - 1;
            while (i < j) {
                int area = (j - i) * Math.min(height[i], height[j]);
                res = Math.max(res, area);
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
            return res;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 要找最大面积，得先知道面积公式是什么
         * S(i, j) = min(h[i], h[j]) × (j − i)
         */
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            while (i < j) {
                res = height[i] < height[j] ?
                        Math.max(res, (j - i) * height[i++]) :
                        Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
