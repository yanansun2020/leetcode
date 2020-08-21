package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GroupStringWithKCh {
    int j = 0;
    List<String> ans = new ArrayList<>();
    List<String> group(String input, int k){
        for(int i =0; i<input.length(); i++){
            if(i > 0 && i%k == 0){
                ans.add(input.substring(j, i));
                j = i;
            }
        }
        ans.add(input.substring(j));
        return ans;
    }
    @Test
    public void test(){
        List<String> ss =group("12345", 2);
    }
}
