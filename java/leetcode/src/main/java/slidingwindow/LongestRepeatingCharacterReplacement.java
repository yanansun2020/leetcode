package slidingwindow;

import org.junit.Test;

/**
 * For example, given the string 'AABAB', maxCount = 3 for 'AABA':
 *
 * When you hit the second 'B', your substring becomes 'BAB', and you would think maxCount should decrease to 2, right?
 * But if that were the case, this substring could never be the solution. Why? The formula for the longest valid
 * substring is (maxCount + k), the # of occurrences of the most common letter plus the # of available operations:
 *  'AABA' -> 3 + 1* = 4
 *  'BAB' ---> 2 + 1* = 3
 *
 *  If this substring's maxCount is smaller than a previous substring's maxCount, it will not provide the solution,
 *  so we can simply ignore it. If the window expands later and maxCount becomes larger than the previous maxCount
 *  we would re-assign maxCount. We only care about maxCount if it's larger than our previous maxCount.
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int max_char_count = 0;
        int res = 0;
        int[] char_count = new int[26];
        for (int right = 0; right < s.length(); right++) {
            Character c_right = s.charAt(right);
            int windowSize = right + 1 - left;
            //find the number of chars that need to replace
            max_char_count = Math.max(max_char_count, ++char_count[c_right-'A']);
            int replacement = windowSize - max_char_count;
            //constrain not satisfied
            while (replacement > k) {
                Character c_left = s.charAt(left);
                char_count[c_left-'A']--;
                left++;
            }
            res = Math.max(res, windowSize);
        }
        return res;
    }
    private int find_max_count(int[] char_count){
        int max_count = 0;
        for (int i = 0; i < 26; i++){
            max_count = Math.max(char_count[i], max_count);
        }
        return max_count;
    }

    private boolean isVowel(Character c){
        String s = "aeiou";
        return s.contains(c+"");
    }

    @Test
    public void test(){
        int res = characterReplacement("AABBBAB", 1);
        res = characterReplacement("ABAA", 0);
        res = characterReplacement("ABAB", 2);
        res = characterReplacement("ABAB", 1);
        res = characterReplacement("AABABBA", 1);
    }
}
