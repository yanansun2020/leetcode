package string;

import algorithm.TrieNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBoldTaginString {
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0 || dict == null || dict.length == 0) {
            return s;
        }
        TrieNode root = new TrieNode();
        for (String dic : dict) {
            root.insertString(dic);
        }
        int[] bold = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            TrieNode curr = root;
            int end = -1;
            for (int j = i; j < s.length(); j++) {
                TrieNode tmp = curr.getByVal(s.charAt(j));
                if (tmp != null) {
                    end = j;
                    curr = curr.getByVal(s.charAt(j));
                }else {
                    break;
                }
            }
            if (end != -1 && curr.isEnd) {
                Arrays.fill(bold, i, end + 1, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (bold[i] == 1) {
                sb.append("<b>");
                while (i < s.length() && bold[i] == 1) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append("</b>");
            }else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{1, 5});
        intervals.add(new int[]{0,4});
        intervals.add(new int[]{7,9});
        String[] dict = new String[]{"abc","123"};
        String ans = addBoldTag("abcxyz123", dict);
        String ans1 = addBoldTag("aaabbcc", new String[]{"a","b","c"});
        String ans2 = addBoldTag("aaabbcc", new String[]{"aaa","aab","bc"});
        String ans3 = addBoldTag("aaabb", new String[]{"aaabb"});

    }
}
