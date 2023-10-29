package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题 杨辉三角
 * 题目标记 pascals-triangle
 * 题目编号 118
 * 时间 2023-10-29 20:06:08
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        int numRows = 5;
        List<List<Integer>> generate = solution.generate(numRows);
        System.out.println(generate);
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 把历史计算结果存储起来并在子问题计算中再使用就算是动态规划的理念
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<Integer>();
                // 第二个for循环一定是等于的
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        List<Integer> preRow = ret.get(i - 1);
                        row.add(preRow.get(j - 1) + preRow.get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
