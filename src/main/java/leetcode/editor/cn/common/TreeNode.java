package leetcode.editor.cn.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNode{");
        sb.append("val=").append(val);
        sb.append('}');
        return sb.toString();
    }

}