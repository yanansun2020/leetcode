package oa.amazon.vo;

import org.junit.Test;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            builIndegreeAndMap(word1, word2, indegree, map);
        }

        Queue<Character> queue = new LinkedList<>();
        initQueue(queue, indegree);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            sb.append(cur);
            List<Character> neighbors = map.get(cur);
            if (neighbors != null && neighbors.size() > 0) {
                for (Character nei : neighbors) {
                    indegree[nei - 'a']--;
                    if (indegree[nei - 'a'] == 0) {
                        queue.offer(nei);
                    }
                }
            }
        }
        return sb.toString();
    }

    private void initQueue(Queue<Character> queue, int[] inDegree) {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                char c = 'a';
                c += i;
                queue.offer(c);
            }
        }
    }

    public Map<Character, List<Character>> builIndegreeAndMap(String word1, String word2, int[] indegree,Map<Character, List<Character>> map) {
        initIndegree(word1, indegree);
        initIndegree(word2, indegree);
        int minLength = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLength; i ++) {
            Character c1 = word1.charAt(i);
            Character c2 = word2.charAt(i);
            if (c1 != c2) {
                List<Character> neighbors = map.getOrDefault(c1, new ArrayList<Character>());
                neighbors.add(c2);
                map.put(c1, neighbors);
                indegree[c2 - 'a']++;
                break;
            }
        }
        return map;
    }


    private void initIndegree(String word, int[] indegree) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (indegree[index] == -1) {
                indegree[index] = 0;
            }
        }
    }

    @Test
    public void test() {
        String[] words = new String[]{"wrt","wrf","er","ett","rftt"};
        String s = alienOrder(words);
        System.out.println(s);
    }
}
