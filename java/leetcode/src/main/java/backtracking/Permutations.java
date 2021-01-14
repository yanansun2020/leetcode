package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * backtracking + bounding function
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        dfs(array, nums, ans);
        return ans;

    }
    public void dfs(List<Integer> array, int[] nums, List<List<Integer>> ans){
        if (array.size() == nums.length){
            ans.add(new ArrayList<>(array));
            return;
        }
        for(int i =0; i < nums.length; i++){
            if(array.contains(nums[i])){
                continue;
            }
            //select a choice
            array.add(nums[i]);
            //expand the choice
            dfs(array, nums, ans);
            //remove the choice
            array.remove(array.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        Permutations test = new Permutations();
        System.out.println(test.permute(array));
    }
}
