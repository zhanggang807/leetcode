package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目标题 找到字符串中所有字母异位词
 * 题目标记 find-all-anagrams-in-a-string
 * 题目编号 438
 * 时间 2023-10-24 12:30:43
 * 已提交
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);// [0,6]
    }


    /**
     * 官方的这个解法是 固定窗口滑动 直接比较数组内容是否相等，理解更简单一点，内部也是用的占位思想
     */
    class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }

            List<Integer> ans = new ArrayList<Integer>();
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; ++i) {
                ++sCount[s.charAt(i) - 'a'];
                ++pCount[p.charAt(i) - 'a'];
            }

            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }

            for (int i = 0; i < sLen - pLen; ++i) {
                --sCount[s.charAt(i) - 'a'];
                ++sCount[s.charAt(i + pLen) - 'a'];
                // 固定窗口向右滑动，每滑一次就比较一次，然后记录位置
                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int count = p.length();
            int[] chars = new int[256];
            for (int i = 0; i < p.length(); i++) {
                // p的每个字符的ascii值当做下标，值是+1，不在p中的值为1，相当于做了一个位图，比排序后再判断hash是否包含要快很多
                chars[p.charAt(i)]++;
            }
            List<Integer> ans = new ArrayList<>();

            int r = 0;
            int l = 0;
            while (r < s.length()) {
                char rc = s.charAt(r);
                chars[rc]--;
                if (chars[rc] >= 0) {
                    count--;// 说明字符找到了，要减次数
                }
                while (count == 0) {
                    // 减到0了，说明都找到了，则记录起始索引位置
                    // 当前窗口的长度，等于p的长度
                    if (r - l + 1 == p.length()) {
                        ans.add(l);
                    }

                    // 下面这一段不太好理解呀！！
                    // 窗口左侧向右移动
                    char lc = s.charAt(l++);
                    chars[lc]++;// 记录窗口左边界的字符值到位图中
                    // 说明左边字符出现在p中，将count加1
                    if (chars[lc] > 0) {
                        // 这里判断>0是因为最初始赋值为1，后减减变成了0，上面又加加了，所以这里才会大于0，判断正确
                        count++;
                    }
                }
                r++;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
