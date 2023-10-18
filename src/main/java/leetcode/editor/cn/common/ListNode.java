package leetcode.editor.cn.common;

/**
 * 单向链表
 *
 * @author zhanggang
 * @date 2023/10/18
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode addNext(int val) {
        next = new ListNode(val);
        return next;
    }


    public ListNode addNext(ListNode next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("val = " + this.val + ", whole = " + this.val);
        ListNode temp = this.next;
        while (temp != null) {
            sb.append(",").append(temp.val);
            temp = temp.next;
        }
        return sb.toString();
    }
}