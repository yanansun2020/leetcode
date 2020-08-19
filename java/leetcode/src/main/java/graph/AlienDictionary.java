package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {
//    topoligical sort
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = buildGraph(words);
        if(graph == null){
            return "";
        }
        List<Character> visited = new ArrayList<>();
        List<Character> ans = new ArrayList<>();
        for(char i='a'; i <='z'; i++){
            if(!graph.containsKey(i)){
                continue;
            }
            if(visited.contains(i)){
                continue;
            }
            if(!dfs(i, visited, ans, graph)){
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=ans.size()-1; i>=0; i--){
            sb.append(ans.get(i));
        }
        return sb.toString();
    }

    boolean dfs(char i, List<Character> visited, List<Character> ans, Map<Character, List<Character>> graph){
        if(visited.contains(i)){
            return ans.contains(i);
        }
        visited.add(i);
        List<Character> neighbors = graph.get(i);
        if(neighbors != null){
            for(Character c : neighbors){
                boolean result = dfs(c, visited, ans, graph);
                if(!result){
                    return false;
                }
            }
        }
        ans.add(i);
        return true;
    }

    Map<Character, List<Character>> buildGraph(String[] words){
//        graph[i][j] 表示从i-j有通路 并且 char(i) < char(j)
//        int[][] graph = new int[26][26];
        Map<Character, List<Character>> graph = new HashMap<>();
        for(String word: words){
            for(char c:word.toCharArray()){
                graph.put(c, new ArrayList<>());
            }
        }

        for(int i=1; i< words.length; i++){
            String curWord = words[i];
            String prev = words[i-1];
            if(prev.length() > curWord.length() && prev.startsWith(curWord)){
                return null;
            }
            int length = Math.min(prev.length(), curWord.length());
            int j = 0;
            while(j < length){
                if(prev.charAt(j) != curWord.charAt(j)){
                    char pre = prev.charAt(j);
                    char cur = curWord.charAt(j);
                    List<Character> neighbor = graph.get(pre);
                    neighbor.add(cur);
                    graph.put(pre, neighbor);
                    break;
                }
                j++;
            }
        }
        return graph;
    }
    @Test
    public void test(){
        String[] array0 = {"z", "z"};
        String ans0 =alienOrder(array0);
        String[] array = {"wrt", "wrf", "er", "ett", "rftt"};
        String ans =alienOrder(array);
        String[] array1 = {"z",
            "x",
            "z"};
        ans = alienOrder(array1);
        String[] array2 = {"z",
            "x"};
        ans = alienOrder(array2);
    }
}
