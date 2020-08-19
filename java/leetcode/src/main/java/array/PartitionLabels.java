package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< S.length(); i++){
            map.put(S.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i =0; i<S.length(); i++){
            end = Math.max(end, map.get(S.charAt(i)));
            if (i == end){
                ans.add(i-start + 1);
                start = i+1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        List<Integer>  result = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(1);
    }
}
