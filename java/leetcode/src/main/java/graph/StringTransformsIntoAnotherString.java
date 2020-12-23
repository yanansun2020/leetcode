package graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            Character ch1 = str1.charAt(i);
            Character ch2 = str2.charAt(i);
            Character character = map.get(ch1);
            if (character == null) {
                map.put(ch1, ch2);
                continue;
            }
            if (character != ch2) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
       boolean res = canConvert("leetcode", "codeleet");
       res = canConvert("aabcc", "ccdee");
    }
}
