package algorithm;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> node;
    public boolean isEnd;
    public TrieNode(){
        node = new HashMap<>();
        isEnd = false;
    }

    public TrieNode getByVal(Character val){
        return node.get(val);
    }

    public void insertString(String s){
        TrieNode current = this;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            TrieNode tmp = current.node.get(ch);
            if (tmp == null){
                tmp = new TrieNode();
                current.node.put(s.charAt(i), tmp);
            }
            current = tmp;
        }
        current.isEnd = true;
    }
}
