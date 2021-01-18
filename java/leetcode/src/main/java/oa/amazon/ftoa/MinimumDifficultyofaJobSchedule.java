package oa.amazon.ftoa;

import java.util.Arrays;

/**
 * back tracking + memo?
 * Time : O(nnd)
 * space : O(nnd)
 */
public class MinimumDifficultyofaJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] memo = new int[d + 1][n];
        for (int[] tmp : memo) {
            Arrays.fill(tmp, -1);
        }
        return dfs(d, 0, jobDifficulty, memo);
    }
    int dfs(int d, int cutPoint, int[] jobDifficulty, int[][] memo){
        if (d == 1) {
            int maxValue = jobDifficulty[cutPoint];
            for (;cutPoint < jobDifficulty.length; cutPoint++){
                maxValue = Math.max(maxValue, jobDifficulty[cutPoint]);
            }
            return maxValue;
        }
        if (memo[d][cutPoint] != -1) {
            return memo[d][cutPoint];
        }
        int maxValueLeft = 0;
        int globalMax = Integer.MAX_VALUE;
        for (int i = cutPoint; i < jobDifficulty.length - d + 1; i++) {
            //max of leftside
            maxValueLeft = Math.max(maxValueLeft, jobDifficulty[i]);
            int maxValueRight = dfs(d - 1, i + 1, jobDifficulty, memo);
            globalMax = Math.min(globalMax, maxValueLeft + maxValueRight);
        }
        return memo[d][cutPoint] = globalMax;
    }
}
