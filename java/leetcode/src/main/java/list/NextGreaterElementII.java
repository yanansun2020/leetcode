package list;
import java.util.Arrays;
import java.util.Stack;
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length * 2;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i< length; i++){
            int k = i % nums.length;
            if (i == 0 || stack.isEmpty()){
                stack.add(i);
                continue;
            }
            while(!stack.isEmpty() && nums[stack.peek()] <nums[k]){
                ans[stack.pop()] = nums[k];
            }
            // important
            if(i< nums.length){
                stack.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        NextGreaterElementII test = new NextGreaterElementII();
        int[] input = {1,2,1};
        int[] result = test.nextGreaterElements(input);
        System.out.println(result);
        int[] input1 = {5,4,3,2,1};
        result = test.nextGreaterElements(input1);
        System.out.println(result);
        int[] input2 = {1,1,1,1};
        result = test.nextGreaterElements(input2);

    }
}