package dp.game;

import org.junit.Test;

public class DivisorGame {
    public boolean divisorGame(int N) {
        Boolean[] memo = new Boolean[N + 1];
        return dfs(N, memo);
    }
    boolean dfs(int n, Boolean[] memo){
        if (n == 1) {
            memo[n] = false;
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        boolean res = false;
        for (int x = 1; x < n && n %x == 0; x++) {
            if (!dfs(n - x, memo)) {
                res = true;
                break;
            }
        }
        memo[n] = res;
        return memo[n];
    }
    @Test
    public void test(){
        boolean res = divisorGame(3);
    }
}
