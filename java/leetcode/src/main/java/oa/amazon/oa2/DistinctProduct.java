package oa.amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctProduct {
    public int getDistinctProduct(int nums, int[] ids, int rem){
        if(ids == null || ids.length == 0){
            return 0;
        }
        Map<Integer, Integer> occuranceMap = new HashMap<>();
        for(int i =0; i< nums; i++){
            occuranceMap.put(ids[i],occuranceMap.getOrDefault(ids[i], 0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(occuranceMap.entrySet());
        Collections.sort(list,(o1, o2)->o1.getValue().compareTo(o2.getValue()));
        int tmpRem = rem;
        int distinctProduct = occuranceMap.size();
        for(Map.Entry<Integer,Integer> entry : list){
            int occur = entry.getValue();
            if(tmpRem >= occur){
                tmpRem -= occur;
                distinctProduct --;
            }
        }
        return distinctProduct;
    }
    @Test
    public void test(){
        int[] ids = {1,1,1,2,3,2};
       int ans = getDistinctProduct(6, ids, 2);
    }
}
