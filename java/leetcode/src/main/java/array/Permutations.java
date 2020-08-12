package array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        dfs(array, nums, ans);
        return ans;

    }
    public void dfs(List<Integer> array, int[] nums, List<List<Integer>> ans){
        if (array.size() == nums.length){
            ans.add(array);
            return;
        }
        for(int i =0; i < nums.length; i++){
            List<Integer> tmp_array = new ArrayList<>(array);
            if(tmp_array.contains(nums[i])){
                continue;
            }
            tmp_array.add(nums[i]);
            dfs(tmp_array, nums, ans);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        Permutations test = new Permutations();
        System.out.println(test.permute(array));
    }
}
