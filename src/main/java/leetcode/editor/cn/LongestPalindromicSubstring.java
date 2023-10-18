package leetcode.editor.cn;

/**
 * 题目标题 最长回文子串
 * 题目标记 longest-palindromic-substring
 * 题目编号 5
 * 时间 2023-10-17 12:58:41
 * 已提交
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    /*
    动态规划听起来很高大上。其实说白了就是空间换时间，将计算结果暂存起来，避免重复计算
    作用和工程中用 redis 做缓存有异曲同工之妙。
    我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。
    试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。
    只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
    进入正题，动态规划关键是找到初始状态和状态转移方程。
    初始状态，l=r 时，此时 dp[l][r]=true。
    状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。
     */

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int strLen = s.length();
            int maxStart = 0; // 最长回文串的起点
            int maxEnd = 0; // 最长回文串的终点
            int maxLen = 1; // 最长回文串的长度

            boolean[][] dp = new boolean[strLen][strLen];

            // 这两个for循环相当于把字符串组合出来了一下
            // 外层 1 -> n * 0 -> [n, n-1, n-2, n-3]内层，基本上在2n跟n方复杂度中间吧，可能需要用排列组合算一下
            for (int r = 1; r < strLen; r++) {
                for (int l = 0; l < r; l++) {

                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            maxStart = l;
                            maxEnd = r;
                        }
                    }

                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
