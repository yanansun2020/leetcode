package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumCosttoCutaStick {
    public int minCost(int n, int[] cuts) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap();
        Arrays.sort(cuts);
        return dp(n, cuts, 0, n, memo);
    }

    private int dp(int n, int[] cuts, int l, int r, Map<Integer, Map<Integer, Integer>> memo) {
        if (memo.containsKey(l) && memo.get(l).containsKey(r)) {
            return memo.get(l).get(r);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] <= l) continue;
            if (cuts[i] >= r) break;
            res = Math.min(res, r - l +
                dp(n, cuts, l, cuts[i], memo) +
                dp(n, cuts, cuts[i], r, memo));
        }
        res = res == Integer.MAX_VALUE ? 0 : res;
        memo.putIfAbsent(l, new HashMap());
        memo.get(l).put(r, res);
        return res;
    }

    public int minCost_not_work(int n, int[] cuts) {
        Arrays.sort(cuts);
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] cut = {0, n};
        queue.offer(cut);
        Integer cost = 0;
        while(!queue.isEmpty()){
            Integer[] top_ele = queue.poll();
            int start = top_ele[0];
            int end = top_ele[1];
            int middle = getNearestValue(cuts, (start + end) /2);
            if (middle > start && middle < end){
                cost += (end - start);
                Integer[] cut0 = {start, middle};
                Integer[] cut1 = {middle, end};
                queue.offer(cut0);
                queue.offer(cut1);
            }
        }
        return cost;
    }

    public int getNearestValue(int[] cuts, int target){
        int left = 0;
        int right = cuts.length -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (cuts[mid] == target){
                return target;
            }
            if (cuts[mid] < target){
                left = mid + 1;
            }
            if (cuts[mid] > target){
                right = mid -1;
            }
        }
        if (left == 0 || left >= cuts.length-1){
            return -1;
        }
        if(Math.abs(cuts[left] -target) < Math.abs(cuts[left-1] - target)){
            return cuts[left];
        }else{
            return cuts[left-1];
        }
    }

    public static void main(String[] args) {
        MinimumCosttoCutaStick test = new MinimumCosttoCutaStick();
        int[] array =  {1,3,4,5};
        System.out.println(test.minCost(7,array ) );
        int[] array1 =  {5,6,1,4,2};
        System.out.println(test.minCost(9,array1 ) );
    }
}
