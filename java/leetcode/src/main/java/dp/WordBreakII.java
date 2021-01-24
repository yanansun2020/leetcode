package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<Integer>[] dp = new ArrayList[n + 1];
        for (int i = 0; i < dp.length; i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(0);
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                if(!dp[j].isEmpty() && wordDict.contains(s.substring(j, i))){
                    dp[i].add(j);
                }
            }
        }
        List<String> res = new ArrayList<>();
        getResult(dp, s, n, "", res);
        return res;
    }
    private void getResult(List<Integer>[] dp, String s, int index, String cur, List<String> ans){
        List<Integer> neighbors = dp[index];
        if (index == 0){
            ans.add(cur);
            return;
        }
        for (Integer neighbor : neighbors){
            getResult(dp, s, neighbor, s.substring(neighbor, index) + " " + cur, ans);
        }
    }

    @Test
    public void test(){
        String s = "catsanddog";
        String[] arr = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> lst = Arrays.asList(arr);
        List<String> ans = wordBreak(s, lst);
    }
}
