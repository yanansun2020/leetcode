package oa.amazon.ftoa;

import org.junit.Test;

/**
 * time O(n^2)
 * space o(n^2)
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        int maxLength = 1;
        String res = s.charAt(0) + "";
        for (int length = 0; length < n; length++) {
            for (int i = 0; i < n - length; i++) {
                int j = i + length;
                if (i == j){
                    matrix[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        matrix[i][j] = i + 1 > j - 1 ? true : matrix[i + 1][j - 1];
                        if (matrix[i][j] && j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                            res = s.substring(i, j + 1);
                        }
                    } else {
                        matrix[i][j] = false;
                    }
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        String s = "cbbd";
        String res = longestPalindrome(s);
    }
}
