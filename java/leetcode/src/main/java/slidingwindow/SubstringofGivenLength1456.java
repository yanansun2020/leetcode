package slidingwindow;

import org.junit.Test;

public class SubstringofGivenLength1456 {
    public int maxVowels(String s, int k) {
        int res = init_num_vowel(s, k);
        int prev_count = res;
        for (int i = 1; i <= s.length() - k; i++) {
            int num_of_vowel = prev_count;
            Character left = s.charAt(i-1);
            if (isVowel(left)) {
                num_of_vowel--;
            }
            Character right = s.charAt(i + k - 1);
            if (isVowel(right)) {
                num_of_vowel++;
            }
            prev_count = num_of_vowel;
            res = Math.max(num_of_vowel, res);
        }
        return res;
    }
    private int init_num_vowel(String s, int k){
        int count = 0;
        for (int i = 0; i < k; i++) {
            Character c = s.charAt(i);
            if (isVowel(c)){
                count++;
            }
        }
        return count;
    }
    private boolean isVowel(Character c){
        String s = "aeiou";
        return s.contains(c+"");
    }
    @Test
    public void test(){
        int res =  maxVowels("leetcode", 3);
    }
}
