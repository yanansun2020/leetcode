package oa.amazon.oa2;

import org.junit.Test;
/**
 * Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.

Don't include the first or final entry. You can only move either down or right at any point in time.

Example 1:

Input:
[[5, 1],
 [4, 5]]

Output: 4
Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.
 */
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
