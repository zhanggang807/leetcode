package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目标题 最长连续序列
 * 题目标记 longest-consecutive-sequence
 * 题目编号 128
 * 时间 2023-10-18 14:36:34
 * 已提交
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {

            Map<Integer, Integer> map = new HashMap<>();
            UF uf = new UF(nums.length);

            for (int i = 0; i < nums.length; i++) {
                // 存在重复元素，跳过
                if (map.containsKey(nums[i])) continue;

                if (map.containsKey(nums[i] - 1)) {
                    uf.union(i, map.get(nums[i] - 1));
                }
                if (map.containsKey(nums[i] + 1)) {
                    uf.union(i, map.get(nums[i] + 1));
                }
                map.put(nums[i], i);
            }
            return uf.getMaxConnectSize();
        }
    }

    class UF {
        private int[] parent;
        private int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            // 注意 别写反了
            size[rootQ] += size[rootP];
        }

        // get root id
        private int find(int x) {
            // 路径压缩
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getMaxConnectSize() {
            int maxSize = 0;
            for (int i = 0; i < parent.length; i++) {
                if (i == parent[i]) {
                    maxSize = Math.max(maxSize, size[i]);
                }
            }
            return maxSize;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}