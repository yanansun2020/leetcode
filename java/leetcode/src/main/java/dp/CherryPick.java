package dp;

public class CherryPick {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if(n == 1) return Math.max(0, grid[0][0]);
        int[][][] dp = new int[50][50][50]; // 1
        
        dfs(grid, 0, 0, 0, dp, n); 
        
        return Math.max(0, dp[0][0][0]); // 2
    }
    
    
    int dfs(int[][] arr, int r1, int c1, int c2, int[][][] dp, int n){
        int r2 = r1+c1-c2; // 3
        
        if(r1>=n || r2>=n || c1>=n || c2>=n || arr[r1][c1]==-1 || arr[r2][c2] == -1) 
            return Integer.MIN_VALUE;
        
        if(dp[r1][c1][c2]!= 0) return dp[r1][c1][c2];
        
        if(r1 == n-1 && c1 == n-1) return arr[n-1][n-1];
        
        int ans = arr[r1][c1];
        // same cell
        if(c1 != c2) ans+=arr[r2][c2];
        
        int dd = dfs(arr, r1+1, c1, c2, dp, n);
        int rd = dfs(arr, r1, c1+1, c2, dp, n);
        int dr = dfs(arr, r1+1, c1, c2+1, dp, n);
        int rr = dfs(arr, r1, c1+1, c2+1, dp, n);
        return dp[r1][c1][c2] = Math.max(dd, Math.max(rd, Math.max(dr, rr)))+ans;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1}, {1,0}};
        CherryPick cherryPick = new CherryPick();
        int cherry = cherryPick.cherryPickup(arr);
        System.out.println(cherry);
    }
}
