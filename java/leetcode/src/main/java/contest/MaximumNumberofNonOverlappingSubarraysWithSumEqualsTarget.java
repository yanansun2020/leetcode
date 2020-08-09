package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        int curNUmber = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        List<List<Integer>> intervals = new ArrayList<List<Integer>>();
        for (int i=0; i<nums.length; i++){
            curNUmber += nums[i];
            Integer tmp = map.get(curNUmber-target);
            if (tmp != null){
                if (intervals.size() == 0 || (tmp + 1 > intervals.get(intervals.size()-1).get(1))){
                    List<Integer> interval = new ArrayList<>();
                    interval.add(tmp + 1);
                    interval.add(i);
                    intervals.add(interval);
                }
            }
            map.put(curNUmber, i);
        }
        return intervals.size();
//        Collections.sort(intervals, (List<Integer> o1, List<Integer> o2) -> (o1.get(0) - o2.get(0)));
//        int count = 0;
//        for(int i = 0; i < intervals.size(); i++){
//            if(i == 0){
//                count ++;
//                continue;
//            }
//            List<Integer> interval = intervals.get(i);
//            Integer start = interval.get(0);
//            Integer end = interval.get(1);
//
//            List<Integer> interval_pre = intervals.get(i-1);
//            Integer start_pre = interval_pre.get(0);
//            Integer end_pre = interval_pre.get(1);
//
//            if(start > end_pre){
//                count ++;
//            }
//        }

    }
    public static void main(String[] args) {
        MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget test = new MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget();
        int[] array0 ={-5,5,-4,5,4};
        System.out.println(test.maxNonOverlapping(array0, 5));

        int[] array1 = {1,1,1,1,1};
        System.out.println(test.maxNonOverlapping(array1, 2));
        int[] array2 = {-1,3,5,1,4,2,-9};
        System.out.println(test.maxNonOverlapping(array2, 6));
        int[] array3 = {-2,6,6,3,5,4,1,2,8};
        System.out.println(test.maxNonOverlapping(array3, 10));
        int[] array4 = {0,0,0};
        System.out.println(test.maxNonOverlapping(array4, 0));
    }
}
