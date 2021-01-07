package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Buy max token with one score,
 * Buy one score with min token
 */
public class BagofTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        int maxScore = 0;
        int score = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i];
                score++;
                maxScore = Math.max(score, maxScore);
                i++;
            } else {
                if (score > 0) {
                    P += tokens[j];
                    j--;
                    score--;
                } else {
                    i++;
                }
            }
        }
        return maxScore;
    }
    @Test
    public void test(){
        int[] nums = new int[]{100,200,300,400};
        int ans = bagOfTokensScore(nums, 200);
        nums = new int[]{100,200};
        ans = bagOfTokensScore(nums, 150);
    }
}
