import java.util.ArrayList;
import java.util.List;

public class Trie {
    public char ch;
    public List<Trie> children;
    public boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.ch = ' ';
        this.children = new ArrayList<>(26);
        this.isEnd = false;
        for (int i=0; i< 26; i++){
            children.add(null);
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for (int index =0; index < word.length(); index++){
            List<Trie> children_1 = trie.children;
            int position = word.charAt(index) - 'a';
            if (children_1.get(position) == null){
                Trie trie_1 = new Trie();
                trie_1.ch = word.charAt(index);
                if (index == word.length() -1){
                    trie_1.isEnd = true;
                }
                children_1.set(position, trie_1);
                trie = trie_1;
            }else{
                trie = children_1.get(position);
                if (index == word.length() -1){
                    trie.isEnd = true;
                }
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (int index =0; index < word.length(); index++){
            List<Trie> children_1 = trie.children;
            int position = word.charAt(index) - 'a';
            Trie trie_1 = children_1.get(position);
            if ( trie_1 == null){
                return false;
            }
            if (index == word.length() -1 && trie_1.isEnd){
                return true;
            }
            trie = trie_1;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (int index =0; index < prefix.length(); index++){
            List<Trie> children_1 = trie.children;
            int position = prefix.charAt(index) - 'a';
            Trie trie_1 = children_1.get(position);
            if ( trie_1 == null){
                return false;
            }
            trie = trie_1;
        }
        return true;
    }
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        obj.insert("app");

        boolean result = obj.search("app");
        boolean result_1 = obj.search("apple");

        boolean result_2 = obj.search("ap");
        boolean result_3 = obj.startsWith("ap");

        System.out.println(result);
    }
}
