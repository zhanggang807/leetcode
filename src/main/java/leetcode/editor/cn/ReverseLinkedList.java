package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

/**
 * 题目标题 反转链表
 * 题目标记 reverse-linked-list
 * 题目编号 206
 * 时间 2023-10-11 22:10:35
 * 已提交
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);
        System.out.println("反转前：" + head);

        // SolutionByRecursive solutionByRecursive = new ReverseLinkedList().new SolutionByRecursive();
        // ListNode listNode = solutionByRecursive.reverseList(head);

        Solution solution = new ReverseLinkedList().new Solution();
        ListNode listNode = solution.reverseList(head);

        System.out.println("反转后：" + listNode);
    }

    /*
     * FIXME 才过了一个月，自己就又写不出来完整代码了，是没有完全理解，还是记不住！！！
     */

    /**
     * 提交答案用 指针法吧，自己再写出来一个递归法
     * 递归解决 recursive 发音：瑞壳儿si五
     * 理解重点：当递归到最后一个节点递归方法返回时，head变量是倒数第二个节点
     * newHead变量才是最后一个节点，所以递归最后返回的是最后一个节点，就是尾变头，然后newHead一直不变了
     * 然后倒数第二个节点.next.next=自己，然后，自己的head.next等于null
     * 递归的目的相当于找到倒数第二个节点，然后方便自己.next.next=自己，然后回退直到第一个节点
     * 还有递归的特性就是相当于一个栈，入栈，出栈，先进后出，比较适合这种场景
     */
    class SolutionByRecursive {
        public ListNode reverseList(ListNode head) {
            // 递归中止条件
            if (head == null || head.next == null) {
                return head;
            }

            // 递归前动作
            ListNode newHead = reverseList(head.next);
            // 递归中核心动作
            head.next.next = head;
            head.next = null;
            // 递归后，一直反向传递，最后尾节点变头节点
            return newHead;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 1，2步在操作指针反向指向，3，4步在进行角色转换，1，4属于相互呼应的操作
         * 5步最后返回pre节点就是翻转后的头节点
         * 重点理解指针反向和角色转换，与两变量值交换有相似之处，需要引入一个额外变量
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                // 1. 先取出当前节点的 下一个节点备用
                ListNode nextTemp = curr.next;
                // 2. 当前节点的下一个节点 指向上一个节点，这一步很重要 反转 指针指向
                curr.next = prev;
                // 3. 当前节点变成上一个节点
                prev = curr;
                // 4. 下一个节点变成当前节点
                curr = nextTemp;
            }
            // 5. 后返回pre节点就是翻转后的头节点
            return prev;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
