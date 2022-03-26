package backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringCombWithLengthK {
    private void getComb(String s, String cur, int k, int start, List<String> res) {
        if (cur.length() == k) {
            res.add(cur);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            getComb(s, cur + c, k, i + 1, res);
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> res = new ArrayList<>();
        StringCombWithLengthK ss = new StringCombWithLengthK();
        ss.getComb(s, "", 3, 0, res);
    }
}
