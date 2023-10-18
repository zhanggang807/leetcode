package leetcode.editor.cn;

import java.util.*;

/**
 * 题目标题 字母异位词分组
 * 题目标记 group-anagrams
 * 题目编号 49
 * 时间 2023-10-18 11:30:45
 * 已提交
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
        /*
        我想到的解法是先把每个字符串里的char做个排序，这样字母异位词 就完全是一个单词了
        然后找到相同单词的索引，为一组输出出来就好了
        感觉挺简单的，为什么是中等难度，重要的是能发现核心规律吧
         */
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<Integer>> wordMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String newStr = new String(charArray);
                List<Integer> indexList = wordMap.getOrDefault(newStr, new ArrayList<Integer>());
                indexList.add(i);
                wordMap.put(newStr, indexList);
            }

            List<List<String>> ans = new ArrayList<>();
            for (List<Integer> value : wordMap.values()) {
                List<String> sameList = new ArrayList<>();
                for (Integer i : value) {
                    sameList.add(strs[i]);
                }
                ans.add(sameList);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
