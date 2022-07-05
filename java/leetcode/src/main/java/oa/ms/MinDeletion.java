package oa.ms;

/**
 * The idea is to use two pointers i and j where i traverses from left to right and j traverses from right to left.
 * While traversing right, get to the first position where s[i] == ‘b’ and similarly while traversing left,
 * get to the first position where s[j] == ‘a’. We also keep on adjusting the count of ‘a’ and ‘b’ accordingly.
 * Now we reach to a point where s[0:i] is all ‘a’ and s[j+1:] is all ‘b’.
 * At this point we need to decide whether we want to delete ‘a’ or ‘b’.
 * So we go greedy and delete that char whose count is less. So if count_a < count_b, we delete char ‘a’ else we delete char ‘b’.
 */
public class MinDeletion {
    public int minimumDeletions(String s) {
        int n=s.length();
        int []dp=new int[n+1];
        int bcount=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='a'){
                dp[i+1]=Math.min(dp[i]+1,bcount);
            }else{
                dp[i+1]=dp[i];
                bcount++;
            }
        }
        return dp[n];

    }
}
