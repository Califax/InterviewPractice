package leetcode;

public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode currRoot = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            if (currRoot.children[currChar - 'a'] == null) {
                TrieNode newNode = new TrieNode(currChar);
                currRoot.children[currChar - 'a'] = newNode;
            }

            currRoot = currRoot.children[currChar - 'a'];
        }
        currRoot.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currRoot = root;

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currRoot.children[currChar - 'a'] == null) {
                return false;
            }
            currRoot = currRoot.children[currChar - 'a'];
        }
        return currRoot.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currRoot = root;

        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (currRoot.children[currChar - 'a'] == null) {
                return false;
            }
            currRoot = currRoot.children[currChar - 'a'];
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        char val;
        boolean isWord = false;

        TrieNode(char val) {
            this.val = val;
        }
    }
}
