package oa.amazon.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] chrs = new int[26];

        Map<Character, List<Character>> neighbors = initNeighbosrs(words, chrs);
        return topSort(neighbors, chrs);
    }

    private String topSort(Map<Character, List<Character>> map,  int[] chrs){
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        int[] visitied = new int[26];
        for(int i = 0; i < chrs.length; i++) {
            char c = 'a' + 1;
            if (!map.containsKey(c)) {
                continue;
            }
            boolean res = dfs(c, map, visitied, stack);
            if (!res) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private boolean dfs(Character cur, Map<Character, List<Character>> map, int[] visited, Stack<Character> stack) {
        if (visited[cur - 'a'] == 1) {
            return false;
        }
        visited[cur - 'a'] = 1;
        List<Character> neis = map.get(cur);
        for(Character c : neis) {
            if (visited[c-'a'] == 1) {
                return false;
            }
            dfs(c, map, visited, stack);
        }
        stack.push(cur);
        visited[cur - 'a'] = 0;
        return true;
    }
    private Map<Character, List<Character>> initNeighbosrs(String[] words, int[] chrs) {
        Map<Character, List<Character>> neighbors = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            Character[] chs = getDiff(pre, cur, chrs);
            List<Character> list = neighbors.getOrDefault(chs[0], new ArrayList<>());
            if (!list.contains(chs[1])) {
                list.add(chs[1]);
                neighbors.put(chs[0], list);
            }

        }
        return neighbors;
    }

    private Character[] getDiff(String s1, String s2, int[] chrs) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int length = Math.min(s1Arr.length, s2Arr.length);
        int i = 0;
        for (; i < length; i++) {
            if (chrs[s1Arr[i] - 'a'] == 0) {
                chrs[s1Arr[i] - 'a'] = 1;
            }
            if (chrs[s2Arr[i] - 'a'] == 0) {
                chrs[s2Arr[i] - 'a' ] = 1;
            }
            if (s1Arr[i] != s2Arr[i]) {
                return new Character[]{s1Arr[i], s2Arr[i]};
            }

        }
        while (i < s1.length()) {
            chrs[s1.charAt(i++) - 'a'] = 1;
        }

        while (i < s2.length()) {
            chrs[s2.charAt(i++) - 'a'] = 1;
        }
        return null;

    }
}
