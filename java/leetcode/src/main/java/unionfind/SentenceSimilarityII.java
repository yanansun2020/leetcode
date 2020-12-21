package unionfind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarityII {
    private static Integer uuid = 0;
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null || words2 == null || (words1.length != words2.length)) {
            return false;
        }
        uuid = 0;
        UnionFind unionFind = new UnionFind(pairs.size() * 2);
        Map<String, Integer> wordIdMap = new HashMap<>();
        for (List<String> pair : pairs) {
            Integer word1Index = getIndex(pair.get(0), wordIdMap);
            Integer word2Index = getIndex(pair.get(1), wordIdMap);
            unionFind.union(word1Index, word2Index);
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) {
                continue;
            }
            Integer word1I = wordIdMap.get(word1);
            Integer word2I = wordIdMap.get(word2);
            if (word1I == null || word2I == null || (unionFind.find(word1I) != unionFind.find(word2I))) {
                return false;
            }
        }
        return true;
    }

    private Integer getIndex(String word, Map<String, Integer> wordIdMap) {
        if (wordIdMap.containsKey(word)) {
            return wordIdMap.get(word);
        }
        wordIdMap.put(word, uuid++);
        return wordIdMap.get(word);
    }

    @Test
    public void test(){
        String[] words1 = new String[]{"great", "acting", "skills"};
        String[] words2 = new String[]{"fine", "drama", "talent"};
        String[][] s = new String[][]{{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
        List<List<String>> pairs = getList(s);
        boolean ans = areSentencesSimilarTwo(words1, words2, pairs);

        s = new String[][]{{"great", "fine"}, {"acting","drama"}, {"skills","talent"}};
        words2 = new String[]{"fine", "painting", "talent"};
        pairs = getList(s);
        ans = areSentencesSimilarTwo(words1, words2, pairs);
    }

    public List<List<String>> getList(String[][] array){
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < array[i].length; j++) {
                row.add(array[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }

}
