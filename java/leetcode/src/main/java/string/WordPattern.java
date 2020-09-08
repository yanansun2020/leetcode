package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> StrChMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            if (StrChMap.get(strArray[i]) == null) {
                StrChMap.put(strArray[i], ch);
            } else {
                if (StrChMap.get(strArray[i]) != ch) {
                    return false;
                }
            }
            String strByPattern = map.get(ch);
            if (strByPattern == null) {
                strByPattern = strArray[i];
                map.put(ch, strByPattern);
            } else{
                if (!strByPattern.equals(strArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        boolean wordPattern = wordPattern("abba", "dog cat cat dog");
        boolean wordPattern1 = wordPattern("abba", "dog cat cat fish");
        boolean wordPattern2 = wordPattern("aaaa", "dog cat cat dog");
        boolean wordPattern3 = wordPattern("abba", "dog dog dog dog");
    }
}
