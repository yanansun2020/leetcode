package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
public class Test {
    public static String minInteger(String num, int k){
        String result = findMin(num, k, 0);
        return result;
    }
    public static String findMin(String nums, int k, int start){
        if (k == 0||start ==nums.length()){
            return nums;
        }
        // List<String> arr = new ArrayList<String>();
        // for (int i=0; i<nums.length(); i++){
        //     arr.add(nums.charAt(i) + "");
        // }
        // Collections.sort(arr);
        // StringBuilder sb = new StringBuilder();
        // for(int j=0; j<arr.size(); j++){
        //     sb.append(arr.get(j));
        // }
        // if (sb.toString().equals(nums)){
        //     return nums;
        // }
        Map<String, List<Integer>> map = new TreeMap<String, List<Integer>>();
        for(int i =start; i<nums.length(); i++){
            List<Integer> lst = map.get(nums.charAt(i) + "");
            if (lst == null){
                lst = new ArrayList<>();
            }
            lst.add(i);
            map.put(nums.charAt(i) + "", lst);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()){
            List<Integer> values = entry.getValue();
            Collections.sort(values);
            Integer v = values.get(0);
            if(v-start <= k){
                nums = nums.substring(0, start)+ nums.substring(v, v+1) + nums.substring(start, v)+nums.substring(v+1);
                k -= (v-start);
                start +=1;
                break;
            }
        }
        return findMin(nums, k, start);
    }
    public static void main(String[] args) {
        String result_1 = minInteger("4321", 4);
        System.out.println(result_1);
        String result_2 = minInteger("100", 1);
        System.out.println(result_2);
        String result_3 = minInteger("100", 2);
        System.out.println(result_3);
        String result_4 = minInteger("100", 3);
        System.out.println(result_4);
        String result_5 = minInteger("36789", 3);
        System.out.println(result_5);
        String result_6 = minInteger("22", 22);
        System.out.println(result_6);
        String result_7 = minInteger("9438957234785635408", 23);
        System.out.println(result_7);
    }
}