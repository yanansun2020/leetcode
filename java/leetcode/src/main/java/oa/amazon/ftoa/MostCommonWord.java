package oa.amazon.ftoa;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord_1(String paragraph, String[] banned) {
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
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> map = new HashMap<>();
            String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
            List<String> bannedList = Arrays.asList(banned);
            for(String word: words){
                if (!banned(word, bannedList)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
            return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
        public boolean banned(String word, List<String> bannedWords){
            return bannedWords.contains(word);
        }
        @Test
        public void test(){
            String ans = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        }
}
