package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {
//    public List<String> findAllConcatenatedWordsInADict(String[] words) {
//    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
//        List<String> wordsList = Arrays.asList(words);
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, 1);
        }
        for(String word : words){
            if(dfs(word, map)){
                ans.add(word);
            }
        }
        return ans;
    }
    public boolean dfs(String word, Map<String, Integer> words){
        for(int i=1; i<=word.length()-1; i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, word.length());
            if(words.get(prefix) != null){
                if(words.get(suffix) != null){
                    return true;
                }
                boolean containSuffix = dfs(suffix, words);
                if(containSuffix){
                    return true;
                }
            }
        }
        return false;
    }
    @Test
    public void test(){
        String[] array = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> result = findAllConcatenatedWordsInADict(array);
    }
}
