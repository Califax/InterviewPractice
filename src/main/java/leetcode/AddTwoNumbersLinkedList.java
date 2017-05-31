package leetcode;

/*
https://leetcode.com/problems/add-two-numbers/#/description

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbersLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode output = new ListNode(0);
        ListNode nextOutput = output;
        nextOutput.next = output;
        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int currSum = curr1.val + curr2.val + carry;
            if (currSum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode nextOut = new ListNode(currSum % 10);
            output.next = nextOut;
            output = nextOut;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int currSum = curr1.val + carry;
            if (currSum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode nextOut = new ListNode(currSum % 10);
            output.next = nextOut;
            output = nextOut;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int currSum = curr2.val + carry;
            if (currSum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode nextOut = new ListNode(currSum % 10);
            output.next = nextOut;
            output = nextOut;
            curr2 = curr2.next;
        }

        if (carry != 0) {
            output.next = new ListNode(1);
        }

        return nextOutput.next;
    }

}
