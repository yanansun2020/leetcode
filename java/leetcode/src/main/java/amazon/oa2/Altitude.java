package amazon.oa2;

import org.junit.Test;

public class Altitude {
    public int maxOfMinElevation(int columnCount, int rowCount, int[][] mat){
        if(mat == null ||mat.length <rowCount
            ||mat[0] ==null|| mat[0].length<columnCount ){
            return -1;
        }
        int[][] dp = new int[rowCount][columnCount];
        dp[0][0] = mat[0][0];
        for(int i =1; i<columnCount; i++){
            dp[0][i] = Math.min(dp[0][i-1], mat[0][i]);
        }
        for(int i =1; i< rowCount; i++){
            for(int j =0; j< columnCount; j++){
                if(j == 0){
                    dp[i][j] = Math.min(mat[i][j], dp[i-1][j]);
                }else{
                    dp[i][j] = Math.min(mat[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[rowCount-1][columnCount-1];
    }
    @Test
    public void test(){
        int[][] mat = {{6,1,6}, {4,5,7}, {2,3,8}};
        int a = maxOfMinElevation(3,3,mat);
    }
}
