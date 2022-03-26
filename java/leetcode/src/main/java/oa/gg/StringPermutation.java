package oa.gg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public List<String> pemutation(String s){
        return dfs(0, s);
    }

    private List<String> dfs(int index, String s) {
        List<String> permutations = new ArrayList<>();
        if (index == s.length()) {
            return permutations;
        }
        List<String> list = dfs(index + 1, s);
        char c = s.charAt(index);
        if (list.isEmpty()) {
            permutations.add(c + "");
            return permutations;
        }
        for (String l : list) {
            insert(l, c, permutations);
        }
        return permutations;
    }

    private void insert(String s, char c, List<String> list) {
        for (int i = 0; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            String res = left + c + right;
            list.add(res);
        }
    }
    @Test
    public void test() {
        String a = "abc";
        List<String> ss = pemutation(a);
    }

}
