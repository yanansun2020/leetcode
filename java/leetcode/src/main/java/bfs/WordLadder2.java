package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        /**
         * import, otherwise TLE
         */
        Set<String> wordSet = new HashSet<>();
        for (String w : wordList) {
            wordSet.add(w);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                Set<String> neighbors = getWords(cur, wordSet, visited);
                if (neighbors != null && neighbors.contains(endWord)) {
                    return steps + 1;
                }
                queue.addAll(neighbors);
            }
            steps++;
        }
        return 0;
    }
    private Set<String> getWords(String beginWord, Set<String> wordList, Set<String> visited){
        Set<String> ans = new HashSet<>();
        int n = beginWord.length();
        for (int i = 0; i < n ; i++) {
            char[] array = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == array[i]) {
                    continue;
                }
                array[i] = c;
                String s = String.valueOf(array);
                if (!visited.contains(s) && wordList.contains(s)) {
                    ans.add(s);
                    visited.add(s);
                }
            }
        }
        return ans;
    }
}
