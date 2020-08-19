package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[\\!|\\?|'|,|;|\\.|' ' ]");
        List<String> bannedList = Arrays.asList(banned);
        String ans = "";
        int mostFrequency = 0;
        for(String word: words){
            if(word == null ||  word.length() ==0){
                continue;
            }
//            word = word.replaceAll("[\\!|\\?|'|,|;|\\.]", "");
            word = word.toLowerCase();
            if (banned(word,bannedList)){
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
            if(map.get(word) > mostFrequency){
                mostFrequency = map.get(word);
                ans = word;
            }
        }
        return ans;
    }
    public boolean banned(String word, List<String> bannedWords){
        return bannedWords.contains(word);
    }
    @Test
    public void test(){
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.print(mostCommonWord(s, banned));

        String s1 = "a, a, a, a, b,b,b,c, c";
        String[] s1Array = {"a"};
        System.out.print(mostCommonWord(s1, s1Array ));
    }
}
