package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目标题 无重复字符的最长子串
 * 题目标记 longest-substring-without-repeating-characters
 * 题目编号 3
 * 时间 2023-10-17 11:12:51
 * 已提交
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        List<String> params = new ArrayList<>();
        params.add("abcabcbb");
        params.add("bbbbb");
        params.add("pwwkew");

        for (String param : params) {
            System.out.println(solution.lengthOfLongestSubstring(param));
        }
    }

    // https://labuladong.gitee.io/algo/di-ling-zh-bfe1b/wo-xie-le--f02cd/
    // /* 滑动窗口算法框架 */
    // void slidingWindow(String s) {
    //     // 用合适的数据结构记录窗口中的数据
    //     HashMap<Character, Integer> window = new HashMap<>();
    //
    //     int left = 0, right = 0;
    //     while (right < s.length()) {
    //         // c 是将移入窗口的字符
    //         char c = s.charAt(right);
    //         window.put(c, window.getOrDefault(c, 0) + 1);
    //         // 增大窗口
    //         right++;
    //         // 进行窗口内数据的一系列更新
    //     ...
    //
    //         /*** debug 输出的位置 ***/
    //         // 注意在最终的解法代码中不要 print
    //         // 因为 IO 操作很耗时，可能导致超时
    //         System.out.printf("window: [%d, %d)\n", left, right);
    //         /********************/
    //
    //         // 判断左侧窗口是否要收缩
    //         while (left < right && window needs shrink) {
    //             // d 是将移出窗口的字符
    //             char d = s.charAt(left);
    //             window.put(d, window.get(d) - 1);
    //             // 缩小窗口
    //             left++;
    //             // 进行窗口内数据的一系列更新
    //         ...
    //         }
    //     }
    // }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();

            int left = 0, right = 0;
            int res = 0; // 记录结果
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断左侧窗口是否要收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }
                // 在这里更新答案
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
