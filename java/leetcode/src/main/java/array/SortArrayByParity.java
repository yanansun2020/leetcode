package array;

import org.junit.Test;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i =0, j = A.length -1;
        while(i < j){
            if(A[i] %2 == 0){
                i++;
            }else if(A[j] % 2 == 1){
                j--;
            }else{
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
        }
        return A;
    }
    @Test
    public void test(){
        int[] ans = sortArrayByParity(new int[]{3,1,2,4});
        int[] ans1 = sortArrayByParity(new int[]{3,2,1,4});
        int[] ans2 = sortArrayByParity(new int[]{2,4,3,1});
        int[] ans3 = sortArrayByParity(new int[]{2,4});
    }
}
