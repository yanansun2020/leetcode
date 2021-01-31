package oa.wepay.oa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ArraySummation {
    public boolean cansum(int[] input1, int[] input2){
        for (int i = 0; i < input2.length; i++) {
            int target = input2[i];
            if(twoSum(input1, target)) {
                return true;
            }
        }
        return false;
    }
    private boolean twoSum(int[] inputs, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int tmp = target - inputs[i];
            if (map.containsKey(tmp)) {
                return true;
            }
            map.put(inputs[i], map.getOrDefault(inputs[i], 0) + 1);
        }
        return false;
    }

    @Test
    public void test(){
        int[] inputs1 = new int[]{-1, 8, 3};
        int[] inputs2 = new int[]{3, 7,2};
        boolean ans = cansum(inputs1, inputs2);
    }
}
