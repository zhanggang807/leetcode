package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

/**
 * 题目标题 环形链表
 * 题目标记 linked-list-cycle
 * 题目编号 141
 * 时间 2023-10-18 16:23:51
 * 已提交
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        ListNode cycleNode = new ListNode(12);

        // 这个链表有环，不要去打印它
        ListNode head = new ListNode(11);
        head.addNext(cycleNode).addNext(13).addNext(14).addNext(cycleNode);
        System.out.println(solution.hasCycle(head));

        System.out.println("----------------------");

        // 这个没有环
        ListNode headNo = new ListNode(21);
        headNo.addNext(22).addNext(23).addNext(24).addNext(25);
        System.out.println(headNo);
        System.out.println(solution.hasCycle(headNo));

    }

    /*
        我一开始想到的方案是 遍历链表用hashmap把链表节点值计数或者判断是否存在
        只要节点值出现了两次或者已经存在就说明有环呀，就停止遍历，比较好理解
        不过这样有额外空间，还是使用双指针的办法吧
        需要了解 Floyd 判圈算法（又称龟兔赛跑算法)
     */

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 快慢指针，如果相遇，说明快指针反过来追上慢指针，一定有环
            if (head == null || head.next == null) return false;

            ListNode fast = head.next;// 快指针当然要快一步，如果速度一样就不是快慢指针了
            ListNode lazy = head;

            // 循环条件这里又栽了，fast一定经过lazy能走的节点，而fast还必须一次走两步，所以要判断fast.next是否为null
            while (fast != null && fast.next != null) {
                if (fast == lazy) return true;
                fast = fast.next.next;// 一次走两步
                lazy = lazy.next;
            }
            return false;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
