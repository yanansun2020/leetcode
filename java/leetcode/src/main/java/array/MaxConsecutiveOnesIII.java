package array;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int j =0 ;
        int length = A.length;
        int maxCount = 0;
        int i = 0;
        for(i =0; i< length; i++){
            if(A[i] == 1){
                continue;
            }
            if(A[i] == 0){
                if(K == 0){
                    maxCount = Math.max(maxCount, i-j);
                    while(A[j] == 1){
                        j++;
                    }
                    j ++;
                    K ++;
                }
                K--;
            }

        }
        return Math.max(maxCount, i-j);
    }
    public static void main(String[] args) {
        MaxConsecutiveOnesIII test = new MaxConsecutiveOnesIII();
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int result = test.longestOnes(A, 3);
        System.out.println(result);
        int[] b = {1,1,1,0,0,0,1,1,1,1,0};
        result = test.longestOnes(b, 2);
        System.out.println(result);
        int[] c = {0,0,0,1};
        result = test.longestOnes(c, 4);
        System.out.println(result);
    }
}