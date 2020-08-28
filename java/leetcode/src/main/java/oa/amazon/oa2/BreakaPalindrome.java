package oa.amazon.oa2;

import org.junit.Test;

public class BreakaPalindrome {
    public String breakPalindrome(String palindrome){
        if(palindrome.length() == 0){
            return "";
        }
        for(int i =0; i<palindrome.length()/2; i++){
            char ch = palindrome.charAt(i);
            if(ch != 'a'){
                return palindrome.substring(0, i)
                    + 'a'
                    + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, palindrome.length()-1) + 'b';
    }
    @Test
    public void test(){
        String s = breakPalindrome("aaa");
        String s1 = breakPalindrome("abccba");
    }
}
