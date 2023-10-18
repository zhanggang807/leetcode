package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

/**
 * 题目标题 相交链表
 * 题目标记 intersection-of-two-linked-lists
 * 题目编号 160
 * 时间 2023-10-18 15:49:47
 * 已提交
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // 注意是代码里判断的是引用相同不是val值相同，所以单独列出来共用节点
        ListNode common1 = new ListNode(31);
        ListNode common2 = new ListNode(32);
        ListNode common3 = new ListNode(33);

        ListNode headA = new ListNode(11);
        headA.addNext(12).addNext(common1).addNext(common2).addNext(common3);

        System.out.println(headA);

        ListNode headB = new ListNode(21);
        headB.addNext(22).addNext(23).addNext(24).addNext(common1).addNext(common2).addNext(common3);
        System.out.println(headB);

        System.out.println(solution.getIntersectionNode(headA, headB));
    }

    /*
        相交点之后的路，距离一样；那么如果相交点之前的路长不同的话，只需要各自都走一遍，速度一样，终会相遇！
        a走完，再重新从b开始走，b走完，再重新从a开始走，这样路就一样了
     */

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
