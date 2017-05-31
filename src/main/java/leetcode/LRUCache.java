package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */
public class LRUCache {

    LRUNode head;
    LRUNode tail;
    int capacity;

    Map<Integer, LRUNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LRUNode lruNode = cache.get(key);
        if (lruNode != null) {
            moveToHead(lruNode);
            return lruNode.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LRUNode currNode = cache.get(key);

        if (currNode == null) {
            currNode = new LRUNode(key, value);
            addNode(currNode);
            if (cache.size() + 1 > capacity) {
                LRUNode toRemove = cache.get(tail.prev.key);
                cache.remove(toRemove.key);
                popTail();
            }
        } else {
            currNode.val = value;
            moveToHead(currNode);
        }

        cache.put(key, currNode);
    }

    private void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(LRUNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(LRUNode node) {
        removeNode(node);
        addNode(node);
    }

    private void popTail() {
        LRUNode toRemove = tail.prev;
        removeNode(toRemove);
    }

    private static class LRUNode {
        LRUNode prev = null;
        LRUNode next = null;
        int val;
        int key;

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("expected 1 got " + cache.get(1));
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        System.out.println("expected 3 got " + cache.get(3));       // returns 3
        cache.get(4);       // returns 4
    }

}
