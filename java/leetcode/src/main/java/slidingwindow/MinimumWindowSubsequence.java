package slidingwindow;

import org.junit.Test;

/**
 * one pointer
 * go forward and backword
 */
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int min_length = Integer.MAX_VALUE;
        int i = 0;
        String res = "";
        while (i < S.length()) {
            int[] indexes = get_index(S, T, i);
            if (indexes == null) {
                return res;
            }
            int start_index = indexes[0];
            int end_index = indexes[1];
            if (end_index - start_index < min_length){
                res = S.substring(start_index, end_index);
                min_length = end_index - start_index;
            }
            i = start_index;
        }
        return res;
    }

    private int[] get_index(String s, String t, int i){
        int j = 0;
        for (; i < s.length() && j < t.length(); i++) {
            Character c_t = t.charAt(j);
            Character c_s = s.charAt(i);
            if (c_t == c_s) {
                j++;
            }
        }
        int end = i;
        i--;
        j--;
        if (j != t.length() - 1) {
            return null;
        }
        for (; i >= 0 && j >= 0; i--) {
            Character c_t = t.charAt(j);
            Character c_s = s.charAt(i);
            if (c_t == c_s) {
                j--;
            }
        }
        int[] index = new int[2];
        int start = i + 1;
        index[0] = start;
        index[1] = end;
        return index;
    }

    @Test
    public void test(){
        String res = minWindow("abcdebdde", "bde");
        res = minWindow("wcbsuiyzacfgrqsqsnodwmxzkz", "xwqe");
        res = minWindow("ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl",
            "ntimcimzah");
    }
}
