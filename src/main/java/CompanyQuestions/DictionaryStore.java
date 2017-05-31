package CompanyQuestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Looking for simple, performant solution and ideally concise code.

At Rubrik we support prefix-search through our snapshotted filesystem,
where if you want to find the file `data.txt` you can type "dat" and the
search results should include the file.

This problem involves prefix searching through a dictionary of words.
Assume the dictionary's words consists ONLY lower-case characters
a to z.

We want to be able to search for unique words based on prefix
and exact length match. For example, when we query "ba2" we
want to know if there exists one and only word in the dictionary
that is prefixed by "ba" and is followed by 2 more characters.
Valid words for "ba2" include [barn, bath, bask].

Suppose we build the dictionary once - we insert each word into
the dictionary once before querying. Then, we will query for
unique words many, many times. The main challenge is how should
we design and implement the dictionary such that queries are
efficient?

To start, assume the query is always in the format [a-z]+[0-9].
In other words, the query is always prefixed by at least one character
and ends with a single digit. The query is always formatted correctly.

Goal:
Design and implement a dictionary structure that supports efficient
queries. The query implementation should follow from this dictionary
design.

Assume average length of words is 20, and there are 30,000 words
in the dictionary.

Examples:

Dictionary = Set(barn, bath, batter, zxy, promise}
query("ba2") == false  // more than 1 match found)
query("bat3") == true  // 1 match found "batter"
query("z1") == false  // no match found
query("promise0") == true  // 1 match found "promise"
*/

public class DictionaryStore {

    private static class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        Map<Integer, List<String>> wordMap = new HashMap<>();

        TrieNode(char c) {
            this.val = c;
        }
    }

    private class Trie {

        TrieNode root = new TrieNode(' ');

        void insert(String word) {
            TrieNode currRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                currRoot.wordMap.get(word.length()).add(word.length() - i, word);

                if (currRoot.children[currChar - 'a'] == null) {
                    TrieNode newNode = new TrieNode(currChar);
                    newNode.wordMap.get(word.length()).add(word.length() - i, word);
                    currRoot.children[currChar - 'a'] = newNode;
                }
                currRoot = currRoot.children[currChar - 'a'];
            }
            currRoot.isWord = true;
        }
        // children collection to other TrieNodes

        // map from length FROM this node to collection of valid words under this subtree
    }
}
//
//    query: "ba2"
//    root -> b -> a -> t -> h
//
//-> b
//-> a
//    Is there a single existing word that is length 2 way?
