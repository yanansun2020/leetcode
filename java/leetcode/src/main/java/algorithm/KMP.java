package algorithm;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class KMP
{
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        int[] next = new int[t.length()];
        for (int i = 1; i < t.length(); ++i) {
            int j = next[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
            j += (t.charAt(i) == t.charAt(j)) ? 1 : 0;
            next[i] = j;
        }
        return r.substring(0, s.length() - next[t.length() - 1]) + s;
    }
    public static void main(String[] args) {
        KMP KMP = new KMP();
        KMP.shortestPalindrome("abad");
    }

    /**
     * idea: find strings with same prefix and suffix
     * @param s
     * @return
     */
    int[] getKMPTable(String s) {
        int[] table = new int[s.length()];
        int j = 0;
        for(int i = 1; i < s.length(); i++){
            while (j > 0 && s.charAt(i) != s.charAt(j) ){
                j = table[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                table[i] = j + 1;
                j++;
            }
        }
        return table;
    }

    /**
     * decide if p is in s
     * @param s
     * @param p
     * @return
     */
    public int[] substringSearch(String s, String p){
        int[] suffixTable = getKMPTable(p);
        int j = 0;
        int i = 0;
        while (i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                j++;
                i++;
                continue;
            }
            if (j == 0){
                i++;
            }else {
                j = suffixTable[j-1];
            }
        }
        if (j == p.length()) {
            return new int[]{i-j, i-1};
        }
        return null;
    }

    @Test
    public void test(){
        int[] ans = substringSearch("abxabcabcaby", "abcaby");
    }
}
