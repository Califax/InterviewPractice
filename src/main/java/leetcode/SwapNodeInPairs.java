package leetcode;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/#/description
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be change
 */

public class SwapNodeInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode newHead = null;

        while (curr != null && curr.next != null) {
            curr = swap(curr, next, prev);
            prev = curr;
            if (newHead == null) {
                newHead = next;
            }
            curr = curr.next;

            if (curr != null) {
                next = curr.next;
            }
        }

        return newHead;
    }

    private ListNode swap(ListNode curr, ListNode next, ListNode prev) {

        curr.next = next.next;
        next.next = curr;

        if (prev != null) {
            prev.next = next;
        }

        return curr;
    }
}
