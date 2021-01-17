package dp.game;

public class Model {
    public boolean canWinNim(int n){
        Boolean[] memo = new Boolean[4];
//        return dfs(n, memo);
        memo[0] = memo[1] = memo[2] = true;
        for (int i = 3; i < n; i++){
            memo[i%4] = !memo[2] || !memo[1] || !memo[0];
        }
        return memo[(n - 1)%4];
    }
    boolean dfs(int n, Boolean[] memo) {
        if (n < 0) {
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        boolean res = false;
        for (int i = 1; i < 4; i++) {
            if (n >= i) {
                res |= !dfs(n - i, memo);
            }
        }
        memo[n] = res;
        return res;
    }
}
