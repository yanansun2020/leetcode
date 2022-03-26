package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses    {
    int maxLength = 0;
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Set<String> res = new HashSet<String>();
        dfs(0, s, 0, 0, sb, res);
        if (res.size() == 0) {
            res.add("");
        }
        return new ArrayList<>(res);
    }

    private void dfs(int index, String s, int left, int right, StringBuilder sb, Set<String> res) {
        if (index >= s.length()) {
            if (left == right && sb.length() >= maxLength) {
                if (sb.length() > maxLength) {
                    maxLength = sb.length();
                    res.clear();
                }
                StringBuilder sb1 = new StringBuilder(sb);
                res.add(sb1.toString());

            }
            return;
        }

        Character c = s.charAt(index);
        if (c == ')') {
            if (left > right) {
                dfs(index + 1, s, left, right + 1, sb.append(c), res);
                sb.deleteCharAt(sb.length() - 1);
            }
            dfs(index + 1, s, left, right, sb, res);
        } else if (c == '(') {
            dfs(index + 1, s, left + 1, right, sb.append(c), res);
            sb.deleteCharAt(sb.length() - 1);
            dfs(index + 1, s, left, right, sb, res);
        } else {
            dfs(index + 1, s, left, right, sb.append(c), res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    @Test
    public void test() {
        String s = "()())()";
        s = "(a)())()";
        s = ")(a";
        List<String> res = removeInvalidParentheses(s);
    }
}
