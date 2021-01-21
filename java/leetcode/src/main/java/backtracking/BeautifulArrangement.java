package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * worst Time complexity: O(N!)
 */
public class BeautifulArrangement {

    public int countArrangement_1(int n) {
        int[] visited = new int[n + 1];
        return dfs(1, n, visited);
    }
    public int dfs(int pos, int n, int[] visited){
        if (pos > n) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++ ) {
            if (visited[i] == 1) {
                continue;
            }
            if (i % pos != 0 && pos % i != 0) {
                continue;
            }
            visited[i] = 1;
            count += dfs(pos + 1, n, visited);
            visited[i] = 0;
        }
        return count;
    }
    @Test
    public void test(){
        int ans = countArrangement_1(4);
    }



    public int countArrangement(int n) {
        List<Integer> lst = new ArrayList<Integer>();
        return dfs(lst, n);
    }
    public int dfs(List<Integer> lst, int n){
        if (lst.size() == n) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++ ) {
            if (lst.contains(i)) {
                continue;
            }
            int size = lst.size();
            if (i%(size + 1)!= 0 && (size + 1)%i != 0) {
                continue;
            }
            lst.add(i);
            count += dfs(lst, n);
            lst.remove(lst.size() - 1);
        }
        return count;
    }
}
