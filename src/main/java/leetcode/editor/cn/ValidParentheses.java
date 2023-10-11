package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 题目标题 有效的括号
 * 题目标记 valid-parentheses
 * 题目编号 20
 * 时间 2023-10-07 17:06:17
 * 已提交
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // String s = "()";
        // String s = "()[]{}";
        // String s = "(]";
        String s = "]";
        // String s = "(";
        System.out.println(solution.isValid(s));

        // JAVA中队列Queue和栈Stack的理解_java stack 和 queue_keep one's resolveY的博客-CSDN博客
        // https://blog.csdn.net/weixin_45433031/article/details/123747691

        // Java集合(四三): ArrayDeque_java arraydeque-CSDN博客
        // https://blog.csdn.net/mingyuli/article/details/115830113

        // 官方推荐使用Deque（双端队列）接口来实现Stack：
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('a'); // 入栈
        Character peek = stack.peek(); // 查看栈顶元素
        System.out.println(stack.pop()); // 出栈
        System.out.println(stack.size()); // 查看数量
        // 推荐双端队列的等效方法，用上方的原生方法名也可以
        stack.addFirst('b'); // 入栈
        Character peekFirst = stack.peekFirst(); // 查看栈顶元素
        System.out.println(stack.removeFirst()); // 出栈
        System.out.println(stack.size()); // 查看数量
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return false;
            }

            // 做这个题特别要注意思维严谨性
            // 各种情况都要考虑到，也要注意代码的if else分支如何处理，理解代表什么含义

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    // 如果一个也没push那说明字符串不为空不合规则，不是以左边括号开始
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // 不为空则继续处理逻辑
                    Character peek = stack.peek();
                    if (c == ')' && peek.charValue() == '('
                            || c == ']' && peek.charValue() == '['
                            || c == '}' && peek.charValue() == '{') {
                        stack.pop();
                    } else {
                        // 也没有正确pop的话，那说明还是配对还是不正确
                       return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
