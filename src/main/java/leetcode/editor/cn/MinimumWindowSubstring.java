package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目标题 最小覆盖子串
 * 题目标记 minimum-window-substring
 * 题目编号 76
 * 时间 2023-10-26 11:40:45
 * 已提交
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = solution.minWindow(s, t);
        System.out.println(ans);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            // 初始化目标字符串词频
            for (int i = 0; i < t.length(); i++) {
                need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
            }

            int right = 0, left = 0;
            int valid = 0;
            int start = 0, minLen = Integer.MAX_VALUE;
            while (right < s.length()) {
                char cur = s.charAt(right);
                right++;
                // 进行窗口数据一系列更新
                if (need.containsKey(cur)) {
                    Integer total = window.getOrDefault(cur, 0);
                    window.put(cur, total + 1);
                    if (window.get(cur).equals(need.get(cur))) {
                        valid++;
                    }
                }
                // 满足条件时，此时已经找到一个解了，需要右移左边界来找更多的解
                while (need.size() == valid) {
                    if (right - left < minLen) {
                        start = left;
                        minLen = right - left;
                    }
                    // d 是将移除窗口的字符串
                    char d = s.charAt(left);
                    // 左边移动窗口
                    left++;
                    // 进行窗口内数据当一系列更新
                    if (window.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
