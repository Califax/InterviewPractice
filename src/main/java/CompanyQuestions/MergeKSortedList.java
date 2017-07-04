package CompanyQuestions;

import leetcode.ListNode;

import java.util.*;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val < o2.val) {
                return 1;
            } else {
                return 0;
            }
        });

        ListNode output = new ListNode(-1);
        ListNode head = output;

        minHeap.addAll(Arrays.asList(lists));

        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            output.next = curr;
            output = curr;
            if (curr.next != null) {
                minHeap.add(curr.next);
            }
        }
        return head.next;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeKSortedList obj = new MergeKSortedList();
        ListNode[] listNodes = {new ListNode(1), new ListNode(3), new ListNode(2)};
        ListNode listNode = obj.mergeKLists(listNodes);
        printList(listNode);
    }
}
