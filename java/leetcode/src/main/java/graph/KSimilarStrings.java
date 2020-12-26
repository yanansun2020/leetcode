package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * bfs, find shortest path, similar to word ladder
 *                                bccaba
 *                                /    \
 *                             accbba   accabb
 *                             /    \      /  \
 *                       acabbc  acacbb abcacb abcabc
 *
 */
public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        return bfs(A, B);
    }
    int bfs(String A, String B){
        Queue<String> queue = new LinkedList<>();
        queue.add(A);
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node.equals(B)) {
                return map.getOrDefault(node, 0);
            }
            for (String s : getNeighbors(node.toCharArray(), B.toCharArray())) {
                if (!map.containsKey(s)) {
                    map.put(s, 1 + map.getOrDefault(node, 0));
                    queue.offer(s);
                }
            }
        }
        return -1;
    }
    List<String> getNeighbors(char[] A, char[] B){
        List<String> neighbors = new ArrayList<>();
        int i = 0;
        for (; i < A.length; i++) {
            if (A[i] != B[i]) {
                break;
            }
        }
        for (int j = i + 1; j < A.length; j++) {
            if (A[j] == B[i]) {
                swap(A, i, j);
                neighbors.add(new String(A));
                swap(A, i, j);
            }
        }
        return neighbors;
    }
    void swap(char[] A, int i, int j){
        char tmp = A[j];
        A[j] = A[i];
        A[i] = tmp;
    }

    @Test
    public void test(){
        String A = "ab";
        String B = "ba";
        int ans = kSimilarity(A, B);
        A = "abc";
        B = "bca";
        ans = kSimilarity(A, B);
        A = "abac";
        B = "baca";
        ans = kSimilarity(A, B);
        A= "bccaba";
        B = "abacbc";
        ans = kSimilarity(A, B);

    }
}
