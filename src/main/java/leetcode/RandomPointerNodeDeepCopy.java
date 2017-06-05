package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/#/solutions
 */
public class RandomPointerNodeDeepCopy {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;

        RandomListNode headCopy = null;

        while (curr != null) {
            RandomListNode copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            if (headCopy == null) {
                headCopy = copy;
            }
            curr = curr.next;
        }

        return headCopy;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
