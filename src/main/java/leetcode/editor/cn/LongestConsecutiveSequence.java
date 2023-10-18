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

    /*
    128. 最长连续序列 - 力扣（LeetCode）
    https://leetcode.cn/problems/longest-consecutive-sequence/solutions/1453487/by-lfool-jdy4/

    利用 Map 进行了一个「下标」和「值」的对应
    利用 Map 进行重复元素的排除
    利用 Map 可快速判断当前并查集中已有元素
    将 num[i] 和 num[i] - 1 和 num[i] + 1 相连      这一点很重要

    还有就是找到长度最大的那个也重要，相当于对原来的并查集做了一个拓展，要记录的东西不一样了

    作者：LFool⚡
    链接：https://leetcode.cn/problems/longest-consecutive-sequence/solutions/1453487/by-lfool-jdy4/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

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
            parent[rootP] = rootQ; // 合并起来
            // 注意 别写反了  这个相当于对原来的通用并查集做了一个拓展修改，只记录根节点的个数，合并起来size也要合并
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
            // 依次比较法 把每个根节点上的节点个数比较出来，找到最大的那个长度数字，返回
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