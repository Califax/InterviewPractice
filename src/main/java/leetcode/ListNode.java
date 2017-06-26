package leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val: " + val;
    }
}
