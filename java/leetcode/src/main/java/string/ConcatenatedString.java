package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedString {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.addNode(w);
        }
        List<String> res = new ArrayList<>();
        for (String s: words) {
            if (search(s,trie)) {
                res.add(s);
            }
        }
        return res;
    }
    private boolean search(String s, Trie trie) {
        for (int i = 0; i < s.length() - 1; i++) {
            String left = s.substring(0, i+1);
            String right = s.substring(i+1);
            if (trie.findString(left) && (trie.findString(right) || search(right, trie))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        String[] words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
        Trie trie = new Trie();
        trie.addNode("cat");
    }
}


class Trie {
    TrieNode root = new TrieNode();
    public void addNode(String s) {
        TrieNode cur = root;
        add(s, 0, cur);
    }

    private void add(String s, int index, TrieNode node) {
        if (index == s.length()) {
            node.isWord = true;
            return;
        }
        TrieNode next = node.children.get(s.charAt(index));
        if (next == null) {
            next = new TrieNode();
            node.children.put(s.charAt(index), next);
        }
        add(s, index + 1, next);
    }

    public boolean findString(String s) {
        TrieNode cur = root;
        return find(s, 0, cur);
    }

    private boolean find(String s, int index, TrieNode node) {
        if (index == s.length()) {
            return node.isWord;
        }
        TrieNode next = node.children.get(s.charAt(index));
        if (next == null) {
            return false;
        }
        return find(s, index + 1, next);
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}
