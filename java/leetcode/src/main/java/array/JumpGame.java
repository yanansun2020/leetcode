package array;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int furthestStep = 0;
        int length = nums.length;
        if (length == 0){
            return true;
        }
        for(int i=0; i <length; i++ ){
            if(i<=furthestStep){
                furthestStep = Math.max(furthestStep, i + nums[i]);
            }
            if (furthestStep >= length-1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGame.canJump(nums));
        int[] num2 = {3,2,1,0,4};
        System.out.println(jumpGame.canJump(num2));
    }
}