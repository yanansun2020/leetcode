package oa.gg;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 给一个string，只包含数字， 比如：“1573829”， 返回所有index i， 要求满足 input[i] = i 。
 * 比如例子里的 3 在 input[3] 上，就是需要返回的。 对于index超过9 的， 比如index = 10， 则需要满足 input[10] = ’1‘，
 * input[11] = '0', 则算满足条件。
 */
public class ValidIndex {
    public List<Integer> getValidIndex(String s) {
        List<Integer> indice = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            if (i < 10 && (i + "").equals(c)) {
                indice.add(i);
            } else if (i >= 10) {
                if (isValid(s, i)) {
                    indice.add(i);
                }
            }
        }
        return indice;
    }

    private boolean isValid(String s, int index) {
        String indexToString = index + "";
        for (int i = 0; i < indexToString.length(); i++) {
            String c = indexToString.charAt(i) + "";
            String cFromS = s.charAt(index + i) + "";
            if (!c.equals(cFromS)) {
                return false;
            }
        }
        return true;
    }
}
