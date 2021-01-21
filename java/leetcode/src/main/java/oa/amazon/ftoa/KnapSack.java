package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * backtracking, try all possible combinations, permutation
 */
public class KnapSack {
    int minElement = Integer.MAX_VALUE;
    List<Pair> ans;
//    int knapsack(int index, int maxW, int arrSize){
//        if(maxW <= 0)
//            return 1;
//        if (index == arrSize) {
//            return Integer.MAX_VALUE;
//        }
//        int ans = Integer.MAX_VALUE;
//        ans= Math.min(pairs[index].second + knapsack(index + 1, maxW - pairs[index].first, arrSize), knapsack(index + 1, maxW, arrSize));
//        return ans;
//    }

    List<Integer> knapsack(int n, int[] eles){
        minElement = Integer.MAX_VALUE;
        ans = new LinkedList<>();
        Map<Integer, Pair> freqMap = new HashMap<>();
        int sum = 0;
        for (int ele : eles) {
            Pair pair = freqMap.getOrDefault(ele, new Pair(ele, 0));
            pair.second += 1;
            freqMap.put(ele, pair);
            sum += ele;
        }
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Pair> entry: freqMap.entrySet()) {
            pairs.add(entry.getValue());
        }
        LinkedList<Pair> res = new LinkedList<>();
        int[] visited = new int[pairs.size()];
        dfs(res, pairs, (int)Math.ceil((double)sum/2), 0, visited);

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).second; j++) {
                lst.add(ans.get(i).first);
            }

        }
        Integer[] tmp = new Integer[lst.size()];
        lst.toArray(tmp);
        return lst;
    }

    void dfs(LinkedList<Pair> res, List<Pair> pairs, int target, int numOfElement, int[] visited){
        if (target <= 0) {
            if (numOfElement < minElement) {
                ans = new ArrayList<>(res);
                minElement = numOfElement;
            }
            return;
        }
        for (int i = 0; i < pairs.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }
            Pair cur = pairs.get(i);
            res.add(cur);
            visited[i] = 1;
            dfs(res, pairs, target - cur.first * cur.second, numOfElement + cur.second, visited);
            visited[i] = 0;
            res.removeLast();
        }
    }

    @Test
    public void test(){
        Pair[] pairs1 = new Pair[]{new Pair(6, 3), new Pair(1, 1), new Pair(6, 1)};
        Pair[] pairs = new Pair[]{new Pair(15, 1), new Pair(60, 3), new Pair(50, 1)};
        int[] nums = new int[]{20, 15, 20, 50, 20};
        List<Integer> ans = knapsack(5, nums);
        nums = new int[]{2, 1, 1, 1};
        ans = knapsack(4, nums);
        nums = new int[]{10, 9, 9, 6, 5, 4, 3, 2, 1};
        ans = knapsack(4, nums);
        nums = new int[]{10, 4, 4, 4, 3};
        ans = knapsack(3, nums);
    }
}
class Pair{
    int first;
    int second;
    Pair(){}
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
